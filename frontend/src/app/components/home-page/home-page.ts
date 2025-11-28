import { Component, DestroyRef, inject, input, OnInit, signal } from '@angular/core';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { Product } from '../../models/product.model';
import { ProductService } from '../../services/product-service';
import { ProductCard } from '../product-card/product-card';
import { SearchBar } from '../search-bar/search-bar';

@Component({
  selector: 'app-home-page',
  imports: [ProductCard, MatProgressSpinnerModule, SearchBar],
  templateUrl: './home-page.html',
  styleUrl: './home-page.scss',
})
export class HomePage implements OnInit {
  productService = inject(ProductService)
  private destroyRef = inject(DestroyRef)
  isError = signal<boolean>(false)
  isLoaded = signal<boolean>(false)
  selectedFillter: string = "name"
  selectedSort: "ASC" | "DESC" = "ASC"

  ngOnInit(): void {
    this.getProducts(true)

  }

  getProducts(isFirst: boolean = false) {
    const subscription = this.productService.getProducts(this.selectedFillter, this.selectedSort).subscribe({
      next: responseList => {
        this.productService.productList = responseList.map(response => Object.assign(new Product(), response))
      },
      error: error => {
        this.isError.set(true)
      },
      complete: () => {
        this.isLoaded.set(true)
        if (isFirst) {
          this.productService.setBaseList = this.productService.productList
        }
      }
    })

    this.destroyRef.onDestroy(() => {
      subscription.unsubscribe()
    })
  }

  changeSort() {
    this.selectedSort = this.selectedSort == "ASC" ? "DESC" : "ASC"
    this.getProducts()
  }

  changeFilter(newFilter: string) {
    this.selectedFillter = newFilter
    this.getProducts()
  }

  searchByName(inputValue: string) {
    if (inputValue.length == 0) {
      this.productService.productList = this.productService.getBaseList
    } else {
      this.productService.productList = this.productService.getBaseList.filter(product =>
        product.getHunProductName?.trim().toLowerCase().substring(0, inputValue.length) == inputValue
      )
    }
  }
}

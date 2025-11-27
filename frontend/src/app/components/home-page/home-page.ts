import { Component, DestroyRef, inject, OnInit, signal } from '@angular/core';
import { ProductCard } from '../product-card/product-card';
import { ProductService } from '../../services/product-service';
import { Product } from '../../models/product.model';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatProgressSpinnerModule, MatSpinner } from '@angular/material/progress-spinner';
import { MatOption, MatSelect } from '@angular/material/select';
import { SearchBar } from '../search-bar/search-bar';

@Component({
  selector: 'app-home-page',
  imports: [ProductCard, MatProgressSpinnerModule, SearchBar],
  templateUrl: './home-page.html',
  styleUrl: './home-page.scss',
})
export class HomePage implements OnInit {
  private productService = inject(ProductService)
  private destroyRef = inject(DestroyRef)
  isError = signal<boolean>(false)
  isLoaded = signal<boolean>(false)
  productList: Product[] = []
  selectedBrand: string = ""
  selectedFillter: string = ""

  ngOnInit(): void {
    const subscription = this.productService.getProducts("", "").subscribe({
      next: responseList => {
        this.productList = responseList
      },
      error: error => {
        console.log(error)
        this.isError.set(true)
      },
      complete: () => {
        this.isLoaded.set(true)
      }
    })

    this.destroyRef.onDestroy(() => {
      subscription.unsubscribe()
    })
  }
}

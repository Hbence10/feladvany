import { Component, DestroyRef, inject, OnInit } from '@angular/core';
import { ProductCard } from '../product-card/product-card';
import { ProductService } from '../../services/product-service';
import { Product } from '../../models/product.model';

@Component({
  selector: 'app-home-page',
  imports: [ProductCard],
  templateUrl: './home-page.html',
  styleUrl: './home-page.scss',
})
export class HomePage implements OnInit {
  private productService = inject(ProductService)
  private destroyRef = inject(DestroyRef)
  productList: Product[] = []

  ngOnInit(): void {
    const subscription = this.productService.getProducts().subscribe({
      next: responseList => {},
      error: error => console.log(error),
      complete: () => {

      }
    })

    this.destroyRef.onDestroy(() => {
      subscription.unsubscribe()
    })
  }
}

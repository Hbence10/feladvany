import { Component, input, OnInit } from '@angular/core';
import { Product } from '../../models/product.model';

@Component({
  selector: 'app-product-card',
  imports: [],
  templateUrl: './product-card.html',
  styleUrl: './product-card.scss',
})
export class ProductCard implements OnInit{
  product = input.required<Product>()

  ngOnInit(): void {
    console.log(this.product())
  }
}

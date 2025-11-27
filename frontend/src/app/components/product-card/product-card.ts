import { ChangeDetectionStrategy, Component, input, OnInit } from '@angular/core';
import { Product } from '../../models/product.model';
import { MatExpansionModule } from '@angular/material/expansion';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-product-card',
  imports: [MatExpansionModule, CommonModule],
  templateUrl: './product-card.html',
  styleUrl: './product-card.scss',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ProductCard implements OnInit{
  product = input.required<Product>()

  ngOnInit(): void {
    console.log(this.product())
  }
}

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
export class ProductCard implements OnInit {
  product = input.required<Product>()
  isIncorrect: boolean = false

  ngOnInit(): void {
    this.isIncorrect = this.product().getSku == null || this.product().getHunProductName == null || this.product().getEnglishProductName == null || this.product().getGrossPriceHuf == null || this.product().getNetPriceHuf == null || this.product().getCurrency == null || this.product().getVatRate == null || this.product().getQuantityAvailable == null || this.product().getStockQuantity == null || this.product().getBrand == null || this.product().getEan == null
  }
}

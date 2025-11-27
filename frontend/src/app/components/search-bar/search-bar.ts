import { Component, inject } from '@angular/core';
import { ProductService } from '../../services/product-service';

@Component({
  selector: 'app-search-bar',
  imports: [],
  templateUrl: './search-bar.html',
  styleUrl: './search-bar.scss',
})
export class SearchBar {
  private productService = inject(ProductService)

  searchProductByName(name: string){
    console.log(
      this.productService.productList.filter(product => product.getHunProductName?.trim().toLowerCase() == name)
    )
  }
}

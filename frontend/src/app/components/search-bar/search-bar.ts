import { Component, inject, output } from '@angular/core';
import { ProductService } from '../../services/product-service';
import { MatCheckbox } from '@angular/material/checkbox';

@Component({
  selector: 'app-search-bar',
  imports: [MatCheckbox],
  templateUrl: './search-bar.html',
  styleUrl: './search-bar.scss',
})
export class SearchBar {
  productService = inject(ProductService)
  changeValid = output()
  changeSort = output()
  changeFilter = output<string>()
  searchByName = output<string>()

  changeValidState(){
    this.productService.onlyValid = !this.productService.onlyValid
    this.changeValid.emit()
  }

  onChangeFilter(selectedFilter: string){
    this.changeFilter.emit(selectedFilter)
  }
}

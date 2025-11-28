import { Component, inject, output } from '@angular/core';
import { MatCheckbox } from '@angular/material/checkbox';
import { MatFormFieldModule, MatLabel } from '@angular/material/form-field';
import { ProductService } from '../../services/product-service';
import { MatInputModule } from '@angular/material/input';
import { MatOption, MatSelect } from '@angular/material/select';
import { MatButton } from '@angular/material/button';

@Component({
  selector: 'app-search-bar',
  imports: [MatCheckbox, MatFormFieldModule, MatInputModule, MatLabel, MatSelect, MatOption, MatButton],
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

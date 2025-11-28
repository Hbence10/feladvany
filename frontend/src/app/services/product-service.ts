import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../models/product.model';

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  private http = inject(HttpClient)
  private baseUrl: string = "http://localhost:8080/products"
  private baseList: Product[] = []
  productList: Product[] = []
  onlyValid: boolean = false

  getProducts(filter: string, sort: "ASC" | "DESC"): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.baseUrl}?filter=${filter}&sort=${sort}&onlyValid=${this.onlyValid}`)
  }

  get getBaseList(): Product[] {
    return this.baseList
  }

  set setBaseList(newList: Product[]){
    this.baseList = newList
  }
}

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
  productList: Product[] = []

  getProducts(filter: string, sort: string): Observable<Product[]>{
    return this.http.get<Product[]>(`${this.baseUrl}`)
  }
}

export class Product {
  constructor(
    public id: number,
    public sku: string,
    public hunProductName: string,
    public englishProductName: string,
    public grossPriceHuf: number,
    public netPriceHuf: number,
    public currency: string,
    public vatRate: number,
    public quantityAvailable: number,
    public stockQuantity: number,
    public brand: string,
    public ean: string,
    public updatedAt: Date
  ) { }


}

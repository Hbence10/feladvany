export class Product {
  constructor(
    private id?: number,
    private sku?: string,
    private hunProductName?: string,
    private englishProductName?: string,
    private grossPriceHuf?: number,
    private netPriceHuf?: number,
    private currency?: string,
    private vatRate?: number,
    private quantityAvailable?: number,
    private stockQuantity?: number,
    private brand?: string,
    private ean?: string,
    private updatedAt?: Date
  ) { }

  get getId(): number {
    return this.id!;
  }

  get getSku(): string {
    return this.sku!;
  }

  get getHunProductName(): string {
    return this.hunProductName!;
  }

  get getEnglishProductName(): string {
    return this.englishProductName!;
  }

  get getGrossPriceHuf(): number {
    return this.grossPriceHuf!;
  }

  get getNetPriceHuf(): number {
    return this.netPriceHuf!;
  }

  get getCurrency(): string {
    return this.currency!;
  }

  get getVatRate(): number {
    return this.vatRate!;
  }

  get getQuantityAvailable(): number {
    return this.quantityAvailable!;
  }

  get getStockQuantity(): number {
    return this.stockQuantity!;
  }

  get getBrand(): string {
    return this.brand!;
  }

  get getEan(): string {
    return this.ean!;
  }

  get getUpdatedAt(): Date {
    return this.updatedAt!;
  }
}

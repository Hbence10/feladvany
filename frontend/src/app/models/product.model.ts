export class Product {
  constructor(
    private id?: number | null,
    private sku?: string | null,
    private hunProductName?: string | null,
    private englishProductName?: string | null,
    private grossPriceHuf?: number | null,
    private netPriceHuf?: number | null,
    private currency?: string | null,
    private vatRate?: number | null,
    private quantityAvailable?: number | null,
    private stockQuantity?: number | null,
    private brand?: string | null,
    private ean?: string | null,
    private updatedAt?: Date | null,
  ) {}

  get getId(): number | null {
    return this.id!;
  }

  get getSku(): string | null{
    return this.sku!;
  }

  get getHunProductName(): string | null{
    return this.hunProductName!;
  }

  get getEnglishProductName(): string | null{
    return this.englishProductName!;
  }

  get getGrossPriceHuf(): number | null{
    return this.grossPriceHuf!;
  }

  get getNetPriceHuf(): number | null{
    return this.netPriceHuf!;
  }

  get getCurrency(): string | null{
    return this.currency!;
  }

  get getVatRate(): number | null{
    return this.vatRate!;
  }

  get getQuantityAvailable(): number | null{
    return this.quantityAvailable!;
  }

  get getStockQuantity(): number | null{
    return this.stockQuantity!;
  }

  get getBrand(): string | null{
    return this.brand!;
  }

  get getEan(): string | null{
    return this.ean!;
  }

  get getUpdatedAt(): Date | null{
    return this.updatedAt!;
  }
}

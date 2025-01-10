package exercise05.entities;

public class ImportedProduct extends Product {
    private Double customFee;

    public ImportedProduct() {
        super();
    }

    public ImportedProduct(String name, Double price, Double customFee) {
        super(name, price);
        this.customFee = customFee;
    }

    public Double getCustomFee() {
        return customFee;
    }

    public void setCustomFee(Double customFee) {
        this.customFee = customFee;
    }

    @Override
    public final String priceTag(){
        return getName() + " $ " + total() + " (Customs fee: $ " + String.format("%.2f", customFee) + ")";
    }

    public Double total(){
        return getPrice() + customFee;
    }

}

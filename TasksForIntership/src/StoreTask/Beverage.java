package StoreTask;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Beverage extends Product implements Perishable {
    private final LocalDate expDate;

    public Beverage(String name, String brand, double price, LocalDate expirationDate) {
        super(name, brand, price);
        this.expDate = expirationDate;
    }

    @Override
    public int daysUntilExpiration(LocalDate purchaseDate) {
        return (int) purchaseDate.until(expDate, ChronoUnit.DAYS);
    }

    @Override
    String showOnReceipt() {
        //Generates only the fist line that has to be shown on the receipt;
        return this.getName() + " - " + this.getBrand();
    }

    @Override
    public double accept(DiscountMaker discountMaker, double productQuantity) {
        return discountMaker.visit(this, productQuantity);
    }
}

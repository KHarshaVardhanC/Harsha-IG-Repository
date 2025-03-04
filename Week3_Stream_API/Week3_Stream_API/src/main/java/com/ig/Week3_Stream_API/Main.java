package com.ig.Week3_Stream_API;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Sample Suppliers
        Supplier s1 = new Supplier(1, "Supplier A");
        Supplier s2 = new Supplier(2, "Supplier B");

        // Sample Products
        List<Product> products = Arrays.asList(
                new Product(1, "Milk", "Dairy", 2.0, 50.0, LocalDate.now().plusDays(5), s1),
                new Product(2, "Rice", "Pulses", 10.0, 500.0, LocalDate.now().plusDays(15), s2),
                new Product(3, "Salt", "Spices", 1.0, 30.0, LocalDate.now().minusDays(2), s1),
                new Product(4, "Oil", "Oils", 5.0, 700.0, LocalDate.now().plusDays(8), s2),
                new Product(5, "Chips", "Snacks", 3.0, 40.0, LocalDate.now().plusDays(20), s1)
        );

        ProductService service = new ProductService(products);

        System.out.println("\n ==> Highest Priced Product: " + service.getHighestPricedProduct().orElse(null));
        System.out.println(" ==> Lowest Priced Product: " + service.getLowestPricedProduct().orElse(null));
        System.out.println(" ==> Expired Products: " + service.getExpiredProducts());
        System.out.println(" ==> Products Expiring in Next 10 Days: " + service.getProductsExpiringInNext10Days());
        System.out.println(" ==> Product Count by Type: " + service.getProductCountByType());
        System.out.println(" ==> Product Count by Supplier: " + service.getProductCountBySupplier());
    }
}

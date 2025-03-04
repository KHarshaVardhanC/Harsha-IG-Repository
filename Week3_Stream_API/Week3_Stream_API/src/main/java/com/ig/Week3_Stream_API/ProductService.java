package com.ig.Week3_Stream_API;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class ProductService {
    List<Product> productList;

    public ProductService(List<Product> productList) {
        this.productList = productList;
    }

    // List Highest Priced Product
    public Optional<Product> getHighestPricedProduct() {
        return productList.stream().max(Comparator.comparingDouble(p -> p.price));
    }

    // List Lowest Priced Product
    public Optional<Product> getLowestPricedProduct() {
        return productList.stream().min(Comparator.comparingDouble(p -> p.price));
    }

    // List Products that have already expired
    public List<Product> getExpiredProducts() {
        return productList.stream()
                .filter(p -> p.expiryDate.isBefore(LocalDate.now()))
                .collect(Collectors.toList());
    }

    // List Product Names that will expire in the next 10 days
    public List<String> getProductsExpiringInNext10Days() {
        return productList.stream()
                .filter(p -> p.expiryDate.isAfter(LocalDate.now()) && p.expiryDate.isBefore(LocalDate.now().plusDays(10)))
                .map(p -> p.name)
                .collect(Collectors.toList());
    }

    // Display count of products by type
    public Map<String, Long> getProductCountByType() {
        return productList.stream()
                .collect(Collectors.groupingBy(p -> p.type, Collectors.counting()));
    }

    // Display count of products based on Supplier name
    public Map<String, Long> getProductCountBySupplier() {
        return productList.stream()
                .collect(Collectors.groupingBy(p -> p.supplier.sname, Collectors.counting()));
    }
}
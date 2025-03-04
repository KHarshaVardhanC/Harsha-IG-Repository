package com.ig.Week3_Stream_API;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Product {
    Integer id;
    String name;
    String type;
    Double qty;
    Double price;
    LocalDate expiryDate;
    Supplier supplier;

    public Product(Integer id, String name, String type, Double qty, Double price, LocalDate expiryDate, Supplier supplier) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.qty = qty;
        this.price = price;
        this.expiryDate = expiryDate;
        this.supplier = supplier;
    }

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", type=" + type + ", qty=" + qty + ", price=" + price
				+ ", expiryDate=" + expiryDate + "]";
	}
}


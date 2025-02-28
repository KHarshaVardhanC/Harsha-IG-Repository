package com.Java.Collections.streams;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Product {
	Integer id;
	String name;
	String type;
	Double qty;
	Double price;
	LocalDate expiryDate;

	public Product(Integer id, String name, String type, Double qty, Double price, LocalDate expiryDate) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.qty = qty;
		this.price = price;
		this.expiryDate = expiryDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getQty() {
		return qty;
	}

	public void setQty(Double qty) {
		this.qty = qty;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", type=" + type + ", qty=" + qty + ", price=" + price
				+ ", expiryDate=" + expiryDate + "]";
	}
}

public class ProductService {

	public static void main(String[] args) {
		
		List<Product> list=new ArrayList<>();
		list.add(new Product(1, "seeds",  "food", 2.5, 51.0, LocalDate.parse("2027-10-11")));
		list.add(new Product(2, "cards",  "things", 2.5, 55.0, LocalDate.parse("2045-10-11")));
		list.add(new Product(3, "soil",  "resource", 2.5, 55.0, LocalDate.parse("2034-10-11")));
		list.add(new Product(4, "cat",  "animal", 2.5, 50.0, LocalDate.parse("2026-10-11")));
		list.add(new Product(5, "seeds1",  "food", 2.5, 55.0, LocalDate.parse("2071-10-11")));
		list.add(new Product(6, "seeds2",  "food", 2.5, 59.0, LocalDate.parse("2023-10-11")));
		list.add(new Product(7, "seeds3",  "food", 2.5, 59.0, LocalDate.parse("2025-03-02")));

		// list Highest priced product
		System.out.println("Products with highest price: ");
		Comparator<Product> priceComp=((p1,p2)-> p2.getPrice().compareTo(p1.getPrice()));
		System.out.println(list.stream().sorted(priceComp).limit(1).collect(Collectors.toList()));;
		
		// list lowest priced product
		System.out.println("Products with lowest price: ");
		Comparator<Product> priceComp1=((p1,p2)-> p1.getPrice().compareTo(p2.getPrice()));
		System.out.println(list.stream().sorted(priceComp1).limit(1).collect(Collectors.toList()));;
		
		
		
		System.out.println("Products that Expired: ");
		LocalDate today=LocalDate.now();
		// list product that already expired
		List<Product> ans= list.stream().filter(product -> product.expiryDate.isBefore(today)).collect(Collectors.toList());
		ans.stream().forEach(x-> System.out.println(x));
	
		// list product names list that will expire in next 10 days
		System.out.println("Products that expire in next 10 days: ");
		LocalDate days10=LocalDate.now().plusDays(10);
		List<Product> ans10= list.stream().filter(product -> product.expiryDate.isAfter(today) && product.expiryDate.isBefore(days10)).collect(Collectors.toList());
		ans10.stream().forEach(x-> System.out.println(x));
		
		
		

	
		// display count of products of different types
		Map<String, Long> countproducts=list.stream().collect(Collectors.groupingBy(Product::getType, Collectors.counting()));
		System.out.println(countproducts);
		


	}
	
	
	
}

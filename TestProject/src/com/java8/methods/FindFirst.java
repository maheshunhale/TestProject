package com.java8.methods;

import java.util.ArrayList;
import java.util.List;

import com.model.Product;

public class FindFirst {

	public static void main(String[] args) {

		List<Product> products = new ArrayList<>();
		products.add(new Product("p1", "mobile 4", 1000, 2, "Manufacturer 1"));
		products.add(new Product("p2", "mobile 2", 700, 4, "Manufacturer 1"));
		products.add(new Product("p3", "laptop 1", 1200, 6, "Manufacturer 2"));
		products.add(new Product("p4", "laptop 2", 7000, 9, "Manufacturer 2"));
		products.add(new Product("p5", "mobile 1", 9000, 9, "Manufacturer 2"));

		System.out.println("Product info with id is p2");
		Product product = products.stream()
				.filter(p -> p.getName().equalsIgnoreCase("mobile 1"))
				.findFirst()
				.get();
		System.out.println(product.toString());

	}

}

package com.java8.methods;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.model.Product;

public class FirstThreeHighestPricedProducts {

	public static void main(String[] args) {

		List<Product> products = new ArrayList<>();
		products.add(new Product("p1", "mobile 4", 1000, 2, "Manufacturer 1"));
		products.add(new Product("p2", "mobile 2", 700, 4, "Manufacturer 1"));
		products.add(new Product("p3", "laptop 1", 1200, 6, "Manufacturer 2"));
		products.add(new Product("p4", "laptop 2", 7000, 9, "Manufacturer 2"));
		products.add(new Product("p5", "mobile 1", 9000, 9, "Manufacturer 2"));
		
		List<Product> l1 = products.stream().sorted(Comparator.comparingLong(Product::getPrice).reversed())
		.limit(3).collect(Collectors.toList());
		
		for(Product p: l1) {
			System.out.println(p);
		}
		
	}

}

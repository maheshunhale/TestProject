package com.java8.methods;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.model.Product;

public class CollectorsInJava8_ConvertingIntoListSetMap {

	public static void main(String[] args) {
		
		List<Product> products = new ArrayList<>();
		products.add(new Product("p1", "Mobile", 1000, 1, "Manufacturer 1"));
		products.add(new Product("p2", "Laptop", 1000, 2, "Manufacturer 1"));
		products.add(new Product("p3", "Moonitor",7000, 3, "Manufacturer 2"));
		products.add(new Product("p4", "Pen", 7000, 4, "Manufacturer 2"));
		products.add(new Product("p5", "Honda", 9000, 5, "Manufacturer 2"));
		products.add(new Product("p6", "Keyboard", 9000, 6, "Manufacturer 1"));
		products.add(new Product("p7", "Mouse", 1000, 7, "Manufacturer 1"));
		products.add(new Product("p8", "Cable", 10000, 8, "Manufacturer 1"));
		
		//Converting to List
		List<String> listOfProducts = products.stream().limit(3)
					.map(Product::getId)
					.collect(Collectors.toList());
		
		System.out.println("-------CONVERTED INTO LIST------");
		System.out.println(listOfProducts);
		
		//Converting to Set
		Set<String> setOfProducts = products.stream().limit(3).map(Product::getId).collect(Collectors.toSet());
		System.out.println("-------CONVERTED INTO SET------");
		System.out.println(setOfProducts);
		
		
		
		//Converting to Map
		Map<String,Product> productMap = products.stream().collect(Collectors.toMap( p -> p.getId(), p -> p));
		System.out.println("-------CONVERTED INTO MAP------");
		for(String key:productMap.keySet()) {
			System.out.println(productMap.get(key));
		} 
		
		
		//Getting comma separated product names from Product List
		String productNames = products.stream().map(Product::getName).collect(Collectors.joining(", "));
		System.out.println("-------COMMA SEPARATED PRODUCT NAMES FROM LIST------");
		System.out.println(productNames);
		
		//Counting Product of each pricing
		Map<Long,Long> priceCounts = products.stream().collect(Collectors.groupingBy(Product::getPrice, Collectors.counting()));
		System.out.println("-------COUNT OF PRODUCTS AT EACH PRICE TAG------");
		for(Long key:priceCounts.keySet()) {
			System.out.println(key+":"+priceCounts.get(key));
		}
		
		
		//Group by product price
		Map<Long,List<Product>> productByPrice = products.stream().collect(Collectors.groupingBy(p -> p.getPrice()));
		System.out.println("-------GROUPING BY PRICE------");
		for(Long key:productByPrice.keySet()) {
			List<Product> temp = productByPrice.get(key);
			for(Product p:temp) {
				System.out.println(p);
			}
		}
		
		
		//Highest Priced Product
		System.out.println("-------HIGHEST PRICE PRODUCT------");
		List<Product> highestPriceProduct = products.stream().sorted(Comparator.comparingLong(Product::getPrice).reversed())
				.limit(1).collect(Collectors.toList());
		System.out.println(highestPriceProduct);
		
		
		
		
		
		//Distinct Sorted Three Highest priced products - ForEach
		products.stream().sorted(Comparator.comparingLong(Product::getPrice).reversed())
		.distinct().limit(3).map(Product::getId).forEach(System.out::println);
		
		
		
		

	}

}

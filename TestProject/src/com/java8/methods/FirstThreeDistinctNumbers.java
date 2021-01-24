package com.java8.methods;

import java.util.stream.IntStream;

public class FirstThreeDistinctNumbers {

	public static void main(String[] args) {
		
		int[] numbers = {4,1,13,90,16,2,0};
		int sum = IntStream.of(numbers)
				 .distinct()
				 .sorted()
				 .limit(3).sum();
				 //.forEach(System.out::println);
		
		System.out.println(sum);
		
	}

}

package com.java8.methods;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class Numbers_InstStream_Demo {

	public static void main(String[] args) {
		
		int[] numbers = {4,1,13,90,16,2,0};
		
		System.out.println("Using IntStream ");
		System.out.println("------------------");
		System.out.println("Minimum Number: "+IntStream.of(numbers).min().getAsInt());
		System.out.println("Maximum Number: "+IntStream.of(numbers).max().getAsInt());
		System.out.println("Average Number: "+IntStream.of(numbers).average().getAsDouble());
		System.out.println("Count Number: "+IntStream.of(numbers).count());
		System.out.println("Sum Number: "+IntStream.of(numbers).sum());
		
		
		IntSummaryStatistics statistics = IntStream.of(numbers).summaryStatistics();
		System.out.println("------------------");
		System.out.println("Using IntSummaryStatistics ");
		System.out.println("Minimum Number: "+statistics.getMin());
		System.out.println("Maximum Number: "+statistics.getMax());
		System.out.println("Average Number: "+statistics.getAverage());
		System.out.println("Count Number: "+statistics.getCount());
		System.out.println("Sum Number: "+statistics.getSum());
	}

}

package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

/**
 * 
 * @author nag-training
 *
 *
 *         Method Reference ==> function pointers in java
 *
 *
 *         why we need ?
 *
 *         to re-use existing methods as functions
 *
 */

class Product {
	private int id;
	private String name;

	public Product(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Product(int id) {
		super();
	}

	public Product() {
	}
}

class FoodUtil {
	public static boolean isNonVegItem(String item) {
		// ...
		return item.equals("nveg");
	}
}

public class Ex3 {

	public static void main(String[] args) {

		List<String> mainMenu = new ArrayList<>();
		mainMenu.add("veg");
		mainMenu.add("nveg");
		mainMenu.add("veg");

		// -------------------------------------------------
		// way-1 : inline function
		// -------------------------------------------------

//		mainMenu.removeIf(item -> item.equals("nveg"));
//		System.out.println(mainMenu);

		// --------------------------------------------------

		// -------------------------------------------------
		// way-2 :explicit external function call
		// -------------------------------------------------

		mainMenu.removeIf(item -> FoodUtil.isNonVegItem(item));
		System.out.println(mainMenu);

		// --------------------------------------------------

		// -------------------------------------------------
		// way-3 :method reference ( MR )
		// -------------------------------------------------

		mainMenu.removeIf(FoodUtil::isNonVegItem);
		System.out.println(mainMenu);

		// --------------------------------------------------

		Supplier<Thread> supplier1 = () -> Thread.currentThread(); // Lambda syntax
		// or
		Supplier<Thread> supplier2 = Thread::currentThread; // MR syntax
		Thread thread = supplier2.get();

		// --------------------------------------------------

		// Examples
		// -----------------------------------------------------------------
		// #1 static method reference
		// -----------------------------------------------------------------

		Function<Integer, String> function = n -> String.valueOf(n);
		// or
		Function<Integer, String> function2 = String::valueOf;
		System.out.println(function2.apply(123));

		BiFunction<Integer, Integer, Integer> biFunction = (n1, n2) -> Integer.compare(n1, n2);
		// or
		BiFunction<Integer, Integer, Integer> biFunction2 = Integer::compare;

		// -----------------------------------------------------------------

		// -----------------------------------------------------------------
		// #2 specified instance method reference
		// -----------------------------------------------------------------

		String str = "ibm";

		IntSupplier supplier4 = () -> str.length();
		// or
		IntSupplier supplier5 = str::length;

		// -----------------------------------------------------------------
		// #3 un-specified instance method reference
		// -----------------------------------------------------------------

		Function<String, Integer> function3 = s -> s.length();
		// or
		Function<String, Integer> function4 = String::length;

		BiFunction<String, Integer, String> function5 = (s, n) -> s.substring(n);
		// or
		BiFunction<String, Integer, String> function6 = String::substring;

		// -----------------------------------------------------------------
		// #3 constructor reference
		// -----------------------------------------------------------------

		Supplier<Product> supplier6 = () -> new Product();
		Supplier<Product> supplier7 = Product::new;

		Function<Integer, Product> function7 = Product::new;

		BiFunction<Integer, String, Product> biFunction3 = Product::new;

	}

}

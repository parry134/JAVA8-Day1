package com.example;

import java.util.function.Consumer;

/**
 * 
 * @author nag-training
 * 
 * 
 *         function-closure
 * 
 *         A closure is a function having access to the parent scope, even after
 *         the parent function has closed.
 * 
 * 
 *
 */

public class Ex5 {

	public static Consumer<String> teach(String sub) {
		System.out.println("teaching " + sub);
		String notes = sub + "-notes";
		Consumer<String> learn = name -> System.out.println(name + "-> learning with " + notes);
		System.out.println("teaching ends..");
		return learn;
	}

	public static void main(String[] args) {

		Consumer<String> learn = teach("java");
		learn.accept("ibm");
		learn.accept("ibm");
		learn.accept("ibm");

	}

}

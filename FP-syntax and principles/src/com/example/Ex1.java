package com.example;

/**
 * 
 * syntax, to create function 
 * 
 * => using 'Lambda' syntax
 * 
 * param(s) -> body
 * 
 * () -> single-line-statement | { multi-line-statement }
 * 
 * a -> single-line-statement | { multi-line-statement }
 * 
 * (a,b) -> single-line-statement | { multi-line-statement }
 * 
 * 
 * 
 * imp-note : type of function in java is 'Functional Interface'
 * 
 * i.e
 * 
 * 'Functional Interface' ==> SAM ( single abstract method )
 * 
 */

@FunctionalInterface
interface Predicate {
	boolean test(String str);
}

public class Ex1 {

	public static void main(String[] args) {

		Predicate predicate1 = new Predicate() {
			@Override
			public boolean test(String str) {
				return str.isEmpty();
			}
		};

		// or

		// How to make function ?
		Predicate predicate2 = (String str) -> {
			return str.isEmpty();
		};
		// or
		Predicate predicate3 = (str) -> {
			return str.isEmpty();
		};
		// or
		Predicate predicate4 = str -> {
			return str.isEmpty();
		};
		// or
		Predicate predicate5 = str -> str.isEmpty();

		// how to invoke function in java ?
		boolean result = predicate5.test("ibm");
		System.out.println(result);

	}

}

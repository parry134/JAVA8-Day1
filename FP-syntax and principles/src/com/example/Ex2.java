package com.example;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;

/**
 * 
 * @author nag-training
 *
 *
 *         standard functional-interfaces ( java.util.function.* )
 *
 */

public class Ex2 {

	public static void main(String[] args) {

		// --------------------------------------------------------------

		Function<String, Integer> function = s -> s.length();
		System.out.println(function.apply("ibm"));

		BiFunction<Integer, Integer, Integer> biFunction = (n1, n2) -> n1 + n2;
		System.out.println(biFunction.apply(12, 13));

		Consumer<String> consumer = str -> System.out.println("hello " + str);
		consumer.accept("Nag");

		BiConsumer<String, String> biConsumer = (s1, s2) -> System.out.println(s1 + " " + s2);
		biConsumer.accept("hello", "world");

		Supplier<String> supplier = () -> "hello";
		System.out.println(supplier.get());

		Predicate<String> predicate = str -> str.isEmpty();
		System.out.println(predicate.test("ibm"));

		UnaryOperator<String> unaryOperator = str -> str.toUpperCase();
		System.out.println(unaryOperator.apply("ibm"));

		BinaryOperator<Integer> binaryOperator = (n1, n2) -> n1 + n2;
		System.out.println(binaryOperator.apply(12, 13));

		// --------------------------------------------------------------
		// functions with primitive-types
		// --------------------------------------------------------------

		BinaryOperator<Integer> binaryOperatorNew = (n1, n2) -> n1 + n2;
		int r = binaryOperatorNew.apply(12, 13);
		System.out.println(r);

		// or

		IntBinaryOperator intBinaryOperator = (n1, n2) -> n1 + n2;
		int r2 = intBinaryOperator.applyAsInt(12, 13);
		System.out.println(r2);

		ToIntFunction<String> intFunction = str -> str.length();
		System.out.println(intFunction.applyAsInt("ibm"));

//		--------------------------------------------------------------

	}

}

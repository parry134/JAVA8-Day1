package com.example;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

/**
 * 
 * @author nag-training
 * 
 * 
 *         with function, we can execute functions lazily ( on demand )
 * 
 *         this will help us to improve performance of appln
 * 
 * 
 *
 */

public class Ex6 {

	public static void main(String[] args) {

//		int result = 1 + 2; // eager
//		IntSupplier intSupplier = () -> 1 + 2;
//		result = intSupplier.getAsInt(); // lazy

		int result = compute("hello", null);
		System.out.println(result);

	}

	public static LocalDateTime getApplnStatus() {
		System.out.println("collecting appln status "); // long running method
		return LocalDateTime.now();
	}

	public static int compute(String s1, String s2) {
		Objects.requireNonNull(s1, () -> "s1 cannot be null" + getApplnStatus());
		Objects.requireNonNull(s2, () -> "s2 cannot be null" + getApplnStatus());
		return s1.hashCode() ^ s2.hashCode();
	}

}

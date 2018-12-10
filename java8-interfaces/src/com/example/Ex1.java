package com.example;

import java.util.Comparator;

/**
 * 
 * @author nag-training
 *
 *
 *
 *         from java8, interface got new boost with default & static behav
 *         
 */

interface Scalable {

	void setScale();

	default void resetScale() {
		// ..
	}

	static boolean isScalable(Object obj) {
		return obj instanceof Scalable;
	}

}

class Box implements Scalable {
	@Override
	public void setScale() {
		// ..
	}
}

public class Ex1 {

	public static void main(String[] args) {

//		-----------------------------------------------------
		Box box = new Box();
		box.setScale();
		box.resetScale();

//		System.out.println(Scalable.isScalable(box));

//		 -----------------------------------------------------

//		String s1 = "abc";
//		String s2 = "xyz";

//		Comparator<String> comparator = (x, y) -> x.compareTo(y);
//		System.out.println(comparator.compare(s1, s2));

//		Comparator<String> revComparator = (x, y) -> y.compareTo(x);
		// or
//		Comparator<String> revComparator = comparator.reversed();
//		System.out.println(revComparator.compare(s1, s2));

//		------------------------------------------------------
		Comparator<String> comparator = (x, y) -> x.compareTo(y);
		Comparator<String> nullsLastComparator = Comparator.nullsLast(comparator);
		int diff = nullsLastComparator.compare("hello", null);
		System.out.println(diff);
//		------------------------------------------------------
	}

}

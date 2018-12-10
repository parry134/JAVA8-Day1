package com.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ex2 {

	public static void main(String[] args) {

		List<String> mainMenu = new ArrayList<>();
		mainMenu.add("veg");
		mainMenu.add("nveg");
		mainMenu.add("veg");
		mainMenu.add("nveg");
		mainMenu.add("veg");
		mainMenu.add("veg");
		mainMenu.add("nveg");
		mainMenu.add("veg");

		// remove all 'nveg' itme(s) from main menu

		// ------------------------------------------
		// imperative style
		// ------------------------------------------

//		Iterator<String> iterator = mainMenu.iterator();
//		while (iterator.hasNext()) {
//			String item = (String) iterator.next();
//			if (item.equals("nveg"))
//				iterator.remove();
//		}
//		System.out.println(mainMenu);

		// ------------------------------------------
		// declarative-style with function ==> Functional Programming
		// ------------------------------------------

		mainMenu.removeIf(item -> item.equals("nveg"));
		System.out.println(mainMenu);

	}

}

package com.example;

import com.example.service.TxrServiceImpl;

public class App {

	public static void main(String[] args) {

		// ---------
		// Init
		// ---------

		System.out.println("---------------------------");

		TxrServiceImpl txrService = new TxrServiceImpl();

		System.out.println("---------------------------");

		// ---------
		// Use
		// ---------

		System.out.println("---------------------------");
		txrService.txr(100.00, "1", "2");
		System.out.println();
		txrService.txr(100.00, "2", "1");

		System.out.println("---------------------------");

		// ---------
		// Destroy
		// ---------
		///
		System.out.println("---------------------------");

		System.out.println("---------------------------");

	}

}

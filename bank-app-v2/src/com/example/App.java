package com.example;

import com.example.repository.AccountRepository;
import com.example.repository.JdbcAccountRepository;
import com.example.repository.JpaAccountRepository;
import com.example.service.TxrService;
import com.example.service.TxrServiceImpl;

public class App {

	public static void main(String[] args) {

		// third-party / container ==> application context

		// ---------
		// Init
		// ---------

		System.out.println("---------------------------");

		AccountRepository jdbcAccRepository = new JdbcAccountRepository();
		AccountRepository jpaAccRepository = new JpaAccountRepository();
		TxrService txrService = new TxrServiceImpl(jpaAccRepository);

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

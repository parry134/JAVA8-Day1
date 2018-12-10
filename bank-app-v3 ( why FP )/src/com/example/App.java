package com.example;

import java.util.List;

import com.example.model.Txn;
import com.example.service.TxnService;

public class App {

	public static void main(String[] args) {

		TxnService txnService = new TxnService();
		List<Txn> txns = txnService.getTxns(1000.00);

		for (Txn txn : txns) {
			System.out.println(txn);
		}

	}

}

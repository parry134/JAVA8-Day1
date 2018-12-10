package com.example.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.model.Txn;
import com.example.model.TxnType;
import com.example.service.lib.Predicate;
import com.example.service.lib.TxnUtilLib;

public class TxnService {

	private static List<Txn> txns = Arrays.asList(new Txn(1212, 1000.00, TxnType.CREDIT, LocalDate.of(2017, 4, 13)),
			new Txn(1213, 2000.00, TxnType.CREDIT, LocalDate.of(2017, 4, 13)),
			new Txn(1214, 2000.00, TxnType.DEBIT, LocalDate.of(2018, 4, 23)),
			new Txn(1215, 1000.00, TxnType.CREDIT, LocalDate.of(2018, 5, 13)),
			new Txn(1216, 4000.00, TxnType.CREDIT, LocalDate.of(2018, 6, 13)),
			new Txn(1217, 6000.00, TxnType.DEBIT, LocalDate.of(2018, 7, 13)),
			new Txn(1218, 7000.00, TxnType.DEBIT, LocalDate.of(2018, 8, 14)),
			new Txn(1219, 1000.00, TxnType.CREDIT, LocalDate.of(2018, 9, 13)),
			new Txn(1220, 8000.00, TxnType.DEBIT, LocalDate.of(2018, 10, 13)));

	public List<Txn> getTxns(double amount) {

		// ----------------------------------------------------
		// way-1: imperative-style ( what + how logic code )
		// ----------------------------------------------------

//		List<Txn> out = new ArrayList<>();
//		for (Txn txn : txns) {
//			if (txn.getAmount() == amount)
//				out.add(txn);
//		}
//		return out;

		// ----------------------------------------------------
		// way-2: declarative -style with Local-Inner class ( what )
		// ----------------------------------------------------

//		class ByAmount implements Predicate {
//			@Override
//			public boolean test(Txn txn) {
//				return txn.getAmount() == amount;
//			}
//		}
//
//		Predicate byAmount = new ByAmount();
//
//		return TxnUtilLib.filter(txns, byAmount);

		// ----------------------------------------------------
		// way-3: declarative -style with Anonymous-Inner class ( what )
		// ----------------------------------------------------

//		Predicate byAmount = new Predicate() {
//			@Override
//			public boolean test(Txn txn) {
//				return txn.getAmount() == amount;
//			}
//		};
//
//		return TxnUtilLib.filter(txns, byAmount);
//		

		// ----------------------------------------------------
		// way-3: declarative -style with Anonymous-Inner class ( what )
		// ----------------------------------------------------

		Predicate byAmount = txn -> txn.getAmount() == amount;
		return TxnUtilLib.filter(txns, byAmount);

	}

	public List<Txn> getTxns(double minAmount, double maxAmount) {

		List<Txn> out = new ArrayList<>();
		for (Txn txn : txns) {
			if (txn.getAmount() >= minAmount && txn.getAmount() <= maxAmount)
				out.add(txn);
		}
		return out;

	}

}

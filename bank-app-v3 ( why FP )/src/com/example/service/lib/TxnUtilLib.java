package com.example.service.lib;

import java.util.ArrayList;
import java.util.List;

import com.example.model.Txn;

// How
public class TxnUtilLib {

	public static List<Txn> filter(List<Txn> txns, Predicate predicate) {
		List<Txn> out = new ArrayList<>();
		for (Txn txn : txns) {
			if (predicate.test(txn))
				out.add(txn);
		}
		return out;
	}

}

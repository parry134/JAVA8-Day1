package com.example.service.lib;

import com.example.model.Txn;

public interface Predicate {

	boolean test(Txn txn);

}

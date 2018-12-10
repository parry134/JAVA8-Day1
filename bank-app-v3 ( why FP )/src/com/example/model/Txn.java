package com.example.model;

import java.time.LocalDate;

public class Txn {

	private int id;
	private double amount;
	private TxnType type;
	private LocalDate date;

	public Txn(int id, double amount, TxnType type, LocalDate date) {
		super();
		this.id = id;
		this.amount = amount;
		this.type = type;
		this.date = date;
	}

	@Override
	public String toString() {
		return "Txn [id=" + id + ", amount=" + amount + ", type=" + type + ", date=" + date + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public TxnType getType() {
		return type;
	}

	public void setType(TxnType type) {
		this.type = type;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

}

package model.entities;

import model.exceptions.DomainException;

public class Account {
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	public void deposit(double amount) {
		balance += amount;
	}

	public void withdraw(double amount) throws DomainException {
		if (balance < amount) {
			throw new DomainException(
					"Não foi possível efetuar saque, saldo insuficiente (R$ " + String.format("%.2f", balance) + ").");
		}
		if (amount > withdrawLimit) {
			throw new DomainException(
					"A quantia excede o limite de saque (R$ " + String.format("%.2f", withdrawLimit) + ").");
		}
		balance -= amount;
	}
}

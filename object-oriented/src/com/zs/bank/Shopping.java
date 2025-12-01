package com.zs.bank;

public interface Shopping {

	double getBalance();
	void withdraw(double amount) throws BalanceException;
}

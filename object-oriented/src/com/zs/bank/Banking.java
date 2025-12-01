package com.zs.bank;

public interface Banking extends Shopping {
	// Application constants
	int INIT_ACNT_NO = 1101;
	double MIN_SAV_BAL = 1000;
	double INIT_CUR_BAL = 5000;
	double MIN_CUR_BAL = 0;
	double OVERDRAFT_LIMIT = 10000;
		
	// Application interface
	double getBalance();
	void deposit(double amount);
	void withdraw(double amount) throws BalanceException;
	void summary();
	void statement();
}

package com.zs.bank;

public class Savings extends Accounts {

	public Savings() {
	}

	public Savings(String holder) {
		super(holder, MIN_SAV_BAL);
		txns = new Transaction[10];
		txns[index ++] = new Transaction("Credit", MIN_SAV_BAL, balance);
	}

	@Override
	public double getBalance() {
		return super.getBalance() - MIN_SAV_BAL;
	}
	
	@Override
	public void withdraw(double amount) throws BalanceException {
		if(amount <= (balance - MIN_SAV_BAL)) {
			balance -= amount;
			txns[index ++] = new Transaction("Debit", amount, balance);
		} else
			throw new BalanceException("Insufficient balance!");
	}
}

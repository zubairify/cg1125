package com.zs.bank;

public class Current extends Accounts {
	private double overdraft;

	public Current() {
	}

	public Current(String holder) {
		super(holder, INIT_CUR_BAL);
		overdraft = OVERDRAFT_LIMIT;
		txns = new CurrentTransaction[10];
		txns[index ++] = new CurrentTransaction("Credit", INIT_CUR_BAL, balance, OVERDRAFT_LIMIT);
	}

	@Override
	public void summary() {
		super.summary();
		System.out.println("Overdraft: " + overdraft);
	}

	@Override
	public void deposit(double amount) {
		overdraft += amount;
		if(overdraft > OVERDRAFT_LIMIT) {
			balance += overdraft - OVERDRAFT_LIMIT;
			overdraft = OVERDRAFT_LIMIT;
		}
		txns[index ++] = new CurrentTransaction("Credit", amount, balance, overdraft);
	}

	@Override
	public void withdraw(double amount) throws BalanceException {
		if(amount <= (balance + overdraft)) {
			balance -= amount;
			if(balance < MIN_CUR_BAL) {
				overdraft += balance;
				balance = MIN_CUR_BAL;
			}
			txns[index ++] = new CurrentTransaction("Debit", amount, balance, overdraft);
		} else
			throw new BalanceException("Insufficient balance!");
	}
}

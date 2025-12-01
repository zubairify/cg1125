package com.zs.bank;

/**
 * This class represents general bank account.
 * @author Zubair
 * @version 1.0
 */
public abstract class Accounts implements Banking {
	private int acntNo;
	private String holder;
	protected double balance;
	protected Transaction[] txns;
	protected int index;

	private static int autogen = INIT_ACNT_NO;

	/** This is default constructor. */
	public Accounts() {
	}

	public Accounts(String holder, double balance) {
		this.acntNo = autogen++;
		this.holder = holder;
		this.balance = balance;
	}

	public void summary() {
		System.out.println("A/C No: " + acntNo);
		System.out.println("Holder: " + holder);
		System.out.println("Balance: " + balance);
	}

	public void statement() {
		for(int i=0;i<index; i++) 
			System.out.println(txns[i].print());
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		balance += amount;
		txns[index ++] = new Transaction("Credit", amount, balance);
	}

	public abstract void withdraw(double amount) throws BalanceException;
}

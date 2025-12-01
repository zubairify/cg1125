package com.zs.cc;

public class CurrencyConverter {

	public double convert(double amount, Currency source, Currency target) {
		return (target.dollarValue() / source.dollarValue()) * amount;
	}
	
	public static void main(String[] args) {
		CurrencyConverter cc = new CurrencyConverter();
		Dollar usd = new Dollar();
		Rupee inr = new Rupee();
		Dirham aed = new Dirham();
		
		System.out.println(cc.convert(100, usd, inr));
		System.out.println(cc.convert(1000, inr, usd));
		System.out.println(cc.convert(100, usd, aed));
		System.out.println(cc.convert(1000, inr, aed));
	}
}

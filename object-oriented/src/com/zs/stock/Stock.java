package com.zs.stock;

public class Stock implements Exchange {
	@Override
	public void setQuote() {
		System.out.println("Set Quote");
	}

	@Override
	public void getQuote() {
		System.out.println("Get Quote");
	}

	@Override
	public void viewQuote() {
		System.out.println("View Quote");
	}
}

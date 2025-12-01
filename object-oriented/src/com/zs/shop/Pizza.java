package com.zs.shop;
import com.zs.bank.PaymentException;
import com.zs.bank.PaymentGateway;
import com.zs.bank.Shopping;

public class Pizza {
	private String size;
	private int toppings;
	private boolean nonveg;
	private boolean extraCheese;
	private double price;
	
	public Pizza() {
	}

	public Pizza(String size, int toppings, boolean nonveg, boolean extraCheese) {
		this.size = size;
		this.toppings = toppings;
		this.nonveg = nonveg;
		this.extraCheese = extraCheese;
		
		switch(size) {
		case "S" : price = extraCheese ? 125 : 100; break;
		case "M" : price = extraCheese ? 200 : 150; break;
		case "L" : price = extraCheese ? 275 : 200; break;
		default : price = 0;
		}
		
		price += (toppings * 25);
		price += nonveg ? 25 : 0;
	}
	
	public void orderSummary() {
		System.out.println("Size: " + size);
		System.out.println("Toppings: " + toppings);
		System.out.println("Non-veg: " + nonveg);
		System.out.println("Extra Cheese: " + extraCheese);
		System.out.println("Price: " + price);
	}
	
	public void placeOrder(Shopping s) {
		try {
			PaymentGateway.payment(s, price);
			System.out.println("Order placed successfully");
		} catch (PaymentException e) {
			System.out.println("Payment declined, order cancelled due to: " + e.getMessage());
			e.printStackTrace();
		}
	}
}

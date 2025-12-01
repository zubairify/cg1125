package com.zs.shop;

import com.zs.bank.PaymentException;
import com.zs.bank.PaymentGateway;
import com.zs.bank.Shopping;

public class ShoppingCart {
	private Product[] items;
	private double total;
	private int index;
	
	public ShoppingCart() {
		items = new Product[5];
	}
	
	public void addToCart(Product p) throws ShoppingException {
		if(p.getStock() == 0)
			throw new ShoppingException("Product out of stock");
		if(index == 5)
			throw new ShoppingException("Your cart is full");
		else {
			items[index ++] = p;
			p.setStock(p.getStock()-1);
			total += p.getPrice();
		}
	}
	
	public void checkout(Shopping s) throws ShoppingException {
		System.out.println("Your order details");
		for(int i=0; i<index; i++)
			items[i].details();
		System.out.println("Cart Total: " + total);
		
		try {
			PaymentGateway.payment(s, total);
			System.out.println("Order placed successfully");
		} catch (PaymentException e) {
			throw new ShoppingException("Payment declined, order cancelled due to: " + e.getMessage());
		}
	}
}

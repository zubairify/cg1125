package com.zs.bank;

public final class PaymentGateway {

	private PaymentGateway() {
	}

	public static boolean payment(Shopping s, double amount) throws PaymentException {
		try {
			s.withdraw(amount);
			return true;
		} catch (BalanceException e) {
			throw new PaymentException(e.getMessage());
		}
	}
}

package com.patterns.ioc;
import org.springframework.stereotype.Component;

@Component //tells that this class object can be created at runtime
public class CreditCardImpl implements CreditCard {

	@Override
	public void makePayment() {
			System.out.println("Payment made");
	}

}

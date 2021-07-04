package com.patterns.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerImpl implements Customer {

	//field level DI
	@Autowired  			//if CreditCard is class, will search for CreditCard class and create its instance and assign to creaditcard
	CreditCard creditcard;  //if CreditCard is interface, will search for its implementation class(CreditCardImpl) and create its instance and assign to creaditcard
	//CreditCard creditcard=new CreditCardImpl(); //without DI
	
	@Autowired				//constructor injection
	CustomerImpl(CreditCard creditcard) {
		this.creditcard = creditcard;
	}
	
	public CreditCard getCreditcard() {
		return creditcard;
	}

	//@Autowired       //setter injection
	public void setCreditcard(CreditCard creditcard) {
		this.creditcard = creditcard;
	}


	@Override
	public void pay() {
		creditcard.makePayment();

	}

}

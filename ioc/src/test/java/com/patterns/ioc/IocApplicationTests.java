package com.patterns.ioc;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class) //wire all the spring beans together
@SpringBootTest				//knows how to locate main class of the application
class IocApplicationTests {

	@Autowired
	Customer customer;
	
	@Test
	void testPayments() {
		customer.pay();
	}

}

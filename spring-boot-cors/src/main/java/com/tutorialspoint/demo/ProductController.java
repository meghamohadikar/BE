package com.tutorialspoint.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@RequestMapping(value = "/products")
	@CrossOrigin
	public String getProduct() {
	   return "MEGHA";
	}
}

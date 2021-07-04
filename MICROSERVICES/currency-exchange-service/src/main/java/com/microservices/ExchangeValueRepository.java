package com.microservices;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long>{  //POJO, primary key
	ExchangeValue findByFromAndTo(String from, String to);
}
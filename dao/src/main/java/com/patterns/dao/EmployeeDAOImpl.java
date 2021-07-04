package com.patterns.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository // tells that we can create instance of this class at runtime
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void create(Employee employee) {
		String sql = "insert into empl values(?,?)";
		jdbcTemplate.update(sql, employee.getId(), employee.getName()); //to insert values in table
	}

}

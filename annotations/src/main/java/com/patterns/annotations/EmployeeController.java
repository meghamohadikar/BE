package com.patterns.annotations;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@PropertySource("file:application3.properties")
public class EmployeeController {
	
	@Autowired
	//@Qualifier("first")
	Emp emp;
	
	@Value("${com}")
	String comm;
	
	@RequestMapping("/emp")
	@ResponseBody
	public String showEmp() {
		//emp.setName("abcd");
		//emp.setDept("xy");
		
		//List<Employee> empList=new ArrayList<Employee>();
		//empList.add(emp);
		String fetchRecords = emp.fetchRecords();
		return comm;
	}

}

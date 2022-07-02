package com.chainsys.application.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class EmployeeController {
	//  @RequestMapping(value="/getAllEmp",method=RequestMethod.GET)
	  @RequestMapping("/getAllEmp")
   public String getAllEmployees() {
		List<Employee> allEmployees = EmployeeDao.getAllEmployee();
		Iterator<Employee> empIterator = allEmployees.iterator();
	    String result = "";
		while (empIterator.hasNext()) {
			Employee emp = empIterator.next();
		
			result += emp.getEmp_id() + ", " + emp.getFirst_name() + ", " + emp.getLast_name() + ", " + emp.getEmail()
					+", "+ emp.getHire_date() + ", " + emp.getJob_id() + ", " + emp.getSalary() ;
		}
		return result;
   }
	  //  @RequestMapping(value="/getEmpById",method=RequestMethod.GET)
	  @RequestMapping("/getEmpById")
	  public String getEmpById(@RequestParam(name="id") String id) {
		 int empId = Integer.parseInt(id);
		  Employee emp = EmployeeDao.getEmployeeById(empId); 
		return emp.getFirst_name()+", "+emp.getLast_name()+", "+emp.getEmail()+", "+emp.getHire_date()+", "+emp.getJob_id()+", "+
				emp.getPhone_number()+", "+emp.getSalary();
	  }
	  @RequestMapping(value="/newemployee",method=RequestMethod.POST)
	  public int addNewEmployee() {
		return 0;
		  
	  }
	  @RequestMapping(value="/updateemployee",method=RequestMethod.PUT)
	  public int updateEmployee() {
		return 1;
		  
	  }
	  @RequestMapping(value="/removeemployee",method=RequestMethod.DELETE)
	  public int deleteEmployee() {
		return 2;
		  
	  }
	  
}

package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

import springfox.documentation.annotations.ApiIgnore;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController
{

	@Autowired
	EmployeeService empservice;
	
	@Autowired
	EmployeeRepository repo;
  

    @ApiIgnore
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
        
        
    }
    
    @RequestMapping(value="/create", method=RequestMethod.POST)
    public Employee createEmployee(@RequestBody Employee emp) {
   
    	 return empservice.createEmployee(emp);
    	
    	
    }
    
    @GetMapping("/getall")
    public List<Employee> allEmployeeDetails(){
    	 return (repo.findAll());
    }
}

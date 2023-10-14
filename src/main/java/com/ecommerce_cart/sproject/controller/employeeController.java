package com.ecommerce_cart.sproject.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce_cart.sproject.model.employee;
import com.ecommerce_cart.sproject.service.employeeService;

@RestController
@RequestMapping("/api/employee")
public class employeeController {

    private employeeService employeeService;

    public employeeController(employeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    // create employee Rest API
    @PostMapping()
    public ResponseEntity<employee> saveemployee(@RequestBody employee employee){

        return new ResponseEntity<employee>(employeeService.saveEmployee(employee),HttpStatus.CREATED) ;
        
    }

    // Get all employee Rest API
    @GetMapping
    public List<employee> getAllemployee(){

        return employeeService.getAllemployee();

    }

    // get employee by id Rest API
    @GetMapping("{id}")
    public ResponseEntity<employee> getemployeeById(@PathVariable("id") Long employeeId){
        return new ResponseEntity<employee>(employeeService.getEmployee(employeeId), HttpStatus.OK);

    }

    // get update employee rest API 
    @PutMapping("{id}")
    public ResponseEntity<employee> updateemployee(@PathVariable("id") long id 
    ,@RequestBody employee employee){

        return new ResponseEntity<employee>(employeeService.updateemployee(employee,id), HttpStatus.OK);

    }

    // get delete employee rest API
    @DeleteMapping("{id}")
    public ResponseEntity <String> deleteemployee(@PathVariable("id") long id){
        employeeService.deleteemployee(id);

        return new ResponseEntity<String>("Employee deleted ", HttpStatus.OK);
        
    }
}

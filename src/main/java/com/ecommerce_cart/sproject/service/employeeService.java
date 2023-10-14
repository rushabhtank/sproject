package com.ecommerce_cart.sproject.service;

import java.util.List;

import com.ecommerce_cart.sproject.model.employee;

public interface employeeService {

    employee saveEmployee(employee employee);

    List<employee> getAllemployee();
    employee getEmployee(long id);

    employee updateemployee(employee employee, Long id);

    void deleteemployee(long id);






}

package com.ecommerce_cart.sproject.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ecommerce_cart.sproject.exception.ResourceNotFound;
import com.ecommerce_cart.sproject.model.employee;
import com.ecommerce_cart.sproject.repository.EmployeeRep;
import com.ecommerce_cart.sproject.service.employeeService;

@Service
public class employeeServiceimpl  implements employeeService{

    private EmployeeRep employeeRep;

    public employeeServiceimpl(EmployeeRep employeeRep) {
        super();
        this.employeeRep = employeeRep;
    }

    @Override
    public employee saveEmployee(employee employee) {
        
        return employeeRep.save(employee);
        
        // throw new UnsupportedOperationException("Unimplemented method 'saveEmployee'");
    }

    @Override
    public List<employee> getAllemployee() {

        return employeeRep.findAll();
       
    }

    @Override
    public employee getEmployee(long id) {
       Optional<employee> employee = employeeRep.findById(id);

       if(employee.isPresent()){
        return employee.get();

       }else{
            throw new ResourceNotFound("Employee", "id", id);
       }

    }

    @Override
    public employee updateemployee(employee employee, Long id) {

        // we need to che id is present in db or not

        employee existingemployee = employeeRep.findById(id).orElseThrow(
            () -> new ResourceNotFound("Employee","Id", id));
        
            existingemployee.setName(employee.getName());
            existingemployee.setLastname(employee.getLastname());
            existingemployee.setEmail(employee.getEmail());

            employeeRep.save(existingemployee);
            return existingemployee;
    }

    @Override
    public void deleteemployee(long id) {

        // check id is available or not
        employeeRep.findById(id).orElseThrow(() -> new 
        ResourceNotFound("Employee", "Id", id));
        
        employeeRep.deleteById(id);

    }
    
}

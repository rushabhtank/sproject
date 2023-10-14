package com.ecommerce_cart.sproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce_cart.sproject.model.employee;

public interface EmployeeRep extends JpaRepository<employee,Long> {

    
    
}

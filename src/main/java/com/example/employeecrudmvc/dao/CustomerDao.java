package com.example.employeecrudmvc.dao;

import com.example.employeecrudmvc.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer,Integer> {
}

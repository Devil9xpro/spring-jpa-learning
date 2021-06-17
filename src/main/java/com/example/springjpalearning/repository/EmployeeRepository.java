package com.example.springjpalearning.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.example.springjpalearning.entity.Employee;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class EmployeeRepository{
    // private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    EntityManager entityManager;

    // insert an employee
    public void insert(Employee employee){
        entityManager.persist(employee);
    }

    public List<Employee> retrieveAllEmployee(){
        return entityManager.createQuery("select e from Employee e", Employee.class).getResultList();
    }
}
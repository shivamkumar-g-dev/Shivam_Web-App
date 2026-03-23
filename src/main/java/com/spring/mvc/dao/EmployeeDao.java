package com.spring.mvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mvc.model.Employee;

@Repository
public class EmployeeDao {
	
	@Autowired
    private final HibernateTemplate hibernateTemplate;

    public EmployeeDao(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    
    public void saveEmployee(Employee emp) {
		System.out.println("EmployeeDao.saveEmployee()");
		hibernateTemplate.saveOrUpdate(emp);   
	}


	public List<Employee> getAllEmployees() {
		return hibernateTemplate.loadAll(Employee.class);
	}
	
	public Employee getEmployeeById(int id) {
		return hibernateTemplate.get(Employee.class, id);
	}
	
	@Transactional
    public void deleteEmployee(int id) {
        Employee emp = hibernateTemplate.get(Employee.class, id);
        if (emp != null) {
            hibernateTemplate.delete(emp);
        }
    }
}
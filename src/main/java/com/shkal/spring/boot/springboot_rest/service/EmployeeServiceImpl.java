package com.shkal.spring.boot.springboot_rest.service;

import com.shkal.spring.boot.springboot_rest.dao.EmployeeDAO;
import com.shkal.spring.boot.springboot_rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDAO employeeDAO;

    @Override
    @Transactional
    public List<Employee> showAllEmployees() {
        return employeeDAO.showAllEmployees();
    }

    @Override
    @Transactional
    public void saveNewEmployee(Employee employee) {
        employeeDAO.saveNewEmployee(employee);
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        return employeeDAO.getEmployee(id);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }
}

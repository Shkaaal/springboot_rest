package com.shkal.spring.boot.springboot_rest.service;

import com.shkal.spring.boot.springboot_rest.dao.EmployeeRepository;
import com.shkal.spring.boot.springboot_rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> showAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveNewEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        Employee emp = null;
        Optional<Employee> optional = employeeRepository.findById(id);
        if (optional.isPresent()) {
            emp = optional.get();
        }
        return emp;
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> getAllByDepartment(String department) {
        return employeeRepository.getAllByDepartment(department);
    }
}

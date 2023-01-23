package com.shkal.spring.boot.springboot_rest.dao;


import com.shkal.spring.boot.springboot_rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> showAllEmployees();

    public void saveNewEmployee(Employee employee);

    public Employee getEmployee(int id);

    public void deleteEmployee(int id);
}

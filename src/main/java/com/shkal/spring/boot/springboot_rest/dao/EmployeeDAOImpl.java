package com.shkal.spring.boot.springboot_rest.dao;

import com.shkal.spring.boot.springboot_rest.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Employee> showAllEmployees() {

//        Session session = entityManager.unwrap(Session.class);

//        List<Employee> employeeList = session
//                .createQuery("from Employee", Employee.class)
//                .getResultList();

//        Query<Employee> query = session.createQuery("from Employee", Employee.class);
//        List<Employee> employeeList = query.getResultList();

        Query query = entityManager.createQuery("from Employee");

        return query.getResultList();
    }

    @Override
    public void saveNewEmployee(Employee employee) {

//        Session session = entityManager.unwrap(Session.class);

        Employee empFromDB = entityManager.merge(employee);
        employee.setId(empFromDB.getId());

//        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(int id) {

//        Session session = entityManager.unwrap(Session.class);

        Employee employee = entityManager.find(Employee.class, id);

        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
//        Session session = entityManager.unwrap(Session.class);

//        Query<Employee> query = session.createQuery("delete from Employee " +
//                "where id =:employeeId");

        Query query = entityManager.createQuery("delete from Employee " +
                "where id =:employeeId");

        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}

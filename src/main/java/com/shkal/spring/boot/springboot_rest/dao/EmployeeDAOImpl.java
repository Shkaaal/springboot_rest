package com.shkal.spring.boot.springboot_rest.dao;

import com.shkal.spring.boot.springboot_rest.entity.Employee;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Employee> showAllEmployees() {

        Session session = entityManager.unwrap(Session.class);

//        List<Employee> employeeList = session
//                .createQuery("from Employee", Employee.class)
//                .getResultList();

        Query<Employee> query = session.createQuery("from Employee", Employee.class);
        List<Employee> employeeList = query.getResultList();

        return employeeList;
    }

    @Override
    public void saveNewEmployee(Employee employee) {

        Session session = entityManager.unwrap(Session.class);

        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(int id) {

        Session session = entityManager.unwrap(Session.class);

        return session.get(Employee.class, id);
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = entityManager.unwrap(Session.class);

        Query<Employee> query = session.createQuery("delete from Employee " +
                "where id =:employeeId");

        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}

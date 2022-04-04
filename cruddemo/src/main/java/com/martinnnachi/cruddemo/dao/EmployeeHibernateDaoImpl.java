package com.martinnnachi.cruddemo.dao;

import com.martinnnachi.cruddemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeHibernateDaoImpl implements EmployeeDao {

    // define fields for entityManager
    private final EntityManager entityManager;


    // set up constructor injection
    @Autowired
    public EmployeeHibernateDaoImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }


    @Override
    public List<Employee> findAll() {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap( Session.class );

        // create a query
        Query<Employee> query = currentSession.createQuery( " from Employee", Employee.class );

        // execute query and get the result list
        List<Employee> employees = query.getResultList();

        // return the results
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap( Session.class );

        // get and return the employee
        return currentSession.get( Employee.class, theId );
    }

    @Override
    public void save(Employee employee) {
        Session currentSession = entityManager.unwrap( Session.class );

        currentSession.saveOrUpdate( employee );

    }

    @Override
    public void deleteById(int theId) {
        Session currentSession = entityManager.unwrap( Session.class );

        Query query = currentSession.createQuery( "delete from Employee where id=:employeeId");

        query.setParameter( "employeeId", theId );

        query.executeUpdate();

    }
}

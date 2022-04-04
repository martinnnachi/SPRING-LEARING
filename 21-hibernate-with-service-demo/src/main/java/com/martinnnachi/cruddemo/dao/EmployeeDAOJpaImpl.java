package com.martinnnachi.cruddemo.dao;

import com.martinnnachi.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDao {

    private EntityManager entityManager;


    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Employee> findAll() {

        // create a query
        Query theQuery = entityManager.createQuery( "from Employee" );

        // execute query and get result list

        // return the results

        return (List<Employee>) theQuery.getResultList();
    }

    @Override
    public Employee findById(int theId) {

        return entityManager.find( Employee.class, theId );
    }

    @Override
    public void save(Employee employee) {

        Employee dbEmployee = entityManager.merge( employee );

        // update with id from db
        employee.setId( dbEmployee.getId() );

    }

    @Override
    public void deleteById(int theId) {
        Query query = entityManager.createQuery( "delete from Employee where id=:employeeId" );

        query.setParameter( "employeeId", theId );

        query.executeUpdate();

    }
}

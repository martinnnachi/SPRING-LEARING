package com.martinnnachi.springdemo.dao;

import com.martinnnachi.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    // need to inject the session factory
    private final SessionFactory sessionFactory;

    public CustomerDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Customer> getCustomers() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query ... sort by last name
        Query<Customer> theQuery = currentSession.createQuery( "from Customer order by lastName", Customer.class );

        // execute query and get result list
        // return the results
        return theQuery.getResultList();
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // save/update the customer
        currentSession.saveOrUpdate( theCustomer );
    }

    @Override
    public Customer getCustomer(int theId) {
        // get the current database session
        Session currentSession = sessionFactory.getCurrentSession();

        // now retrieve/read from database using the primary key and return the result
        return currentSession.get( Customer.class, theId );
    }
}

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

    @Override
    public void deleteCustomer(int theId) {

        Session currentSession = sessionFactory.getCurrentSession();

        Query theQuery = currentSession.createQuery( "delete from Customer where id=:customerId" );
        theQuery.setParameter( "customerId", theId );

        theQuery.executeUpdate();

    }

    @Override
    public List<Customer> searchCustomers(String theSearchName) {

        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Customer> query;

        // only search if theSearchName is not empty
        if (theSearchName != null && theSearchName.trim().length() > 0) {
            // search for first name or last name... case-insensitive
            query = currentSession.createQuery( "from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class );
            query.setParameter( "theName", "%" + theSearchName.toLowerCase() + "%" );
        } else {
            // theSearchName is empty, so just get all customers
            query = currentSession.createQuery( "from Customer ", Customer.class );
        }

        // execute query and get resultList()
        return query.getResultList();
    }
}

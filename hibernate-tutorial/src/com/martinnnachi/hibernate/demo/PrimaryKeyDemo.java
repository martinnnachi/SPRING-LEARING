package com.martinnnachi.hibernate.demo;

import com.martinnnachi.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass( Student.class )
                .buildSessionFactory();

        // create a session

        try (factory) {
            Session session = factory.getCurrentSession();

            // create 3 student objects
            System.out.println( "Creating a new student objects..." );
            Student tempStudent1 = new Student( "Glo", "Nnach", "Glo@miya.com" );
            Student tempStudent2 = new Student( "Edi", "Afi", "edi@afiya.com" );
            Student tempStudent3 = new Student( "Alex", "Oba", "lex@soto.com" );

            // start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println( "Saving the students..." );
            session.save( tempStudent1 );
            session.save( tempStudent2 );
            session.save( tempStudent3 );

            // commit transaction
            session.getTransaction().commit();

            System.out.println( "Done!" );

        }

    }
}

package com.martinnnachi.hibernate.demo;

import com.martinnnachi.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass( Student.class )
                .buildSessionFactory();

        // create a session

        try (factory) {
            Session session = factory.getCurrentSession();

            // create student object
            System.out.println( "Creating a new student object..." );
            Student tempStudent = new Student( "Elesie", "Warenya", "ware@mart.com" );

            // start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println( "Saving the student..." );
            System.out.println( tempStudent );
            session.save( tempStudent );

            // commit transaction
            session.getTransaction().commit();

            // NEW CODE

            // find out the student's id: primary key
            System.out.println( "Student saved. Generated id: " + tempStudent.getId() );

            // now get a new session and start a transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve a student based on the id: primary key
            System.out.println( "\nGetting student with id: " + tempStudent.getId() );
            Student myStudent = session.get( Student.class, tempStudent.getId() );
            System.out.println("Get complete: " + myStudent);

            // commit a transaction
            session.getTransaction().commit();

            System.out.println( "Done!" );

        }
    }
}

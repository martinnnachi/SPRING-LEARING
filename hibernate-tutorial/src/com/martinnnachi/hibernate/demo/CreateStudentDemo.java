package com.martinnnachi.hibernate.demo;

import com.martinnnachi.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass( Student.class )
                .buildSessionFactory();

        // create a session
        Session session = factory.getCurrentSession();

        try {

            // create student object
            System.out.println("Creating a new student object...");
            Student tempStudent = new Student("Mart", "Nnach", "mnnach@mart.com");

            // start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the student...");
            session.save( tempStudent );

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        }finally {
            factory.close();
        }
    }
}

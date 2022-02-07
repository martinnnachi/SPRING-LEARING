package com.martinnnachi.hibernate.demo;

import com.martinnnachi.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass( Student.class )
                .buildSessionFactory();

        // create a session

        try (factory) {
            Session session = factory.getCurrentSession();

            int studentId = 1;


            // start a transaction
            session.beginTransaction();

            // retrieve a student based on the id: primary key
            System.out.println( "\nGetting student with id: " + studentId );
            Student myStudent = session.get( Student.class, studentId );

            System.out.println( "Updating student..." );
            myStudent.setFirstName( "Gloria" );

            // commit a transaction
            session.getTransaction().commit();

            // NEW CODE
            session = factory.getCurrentSession();
            session.beginTransaction();

            // Update email for all students
            System.out.println( "Update email for all students" );

            session.createQuery( "update Student set email='stu@gmail.com'" ).executeUpdate();


            // commit a transaction
            session.getTransaction().commit();


            System.out.println( "Done!" );

        }
    }
}

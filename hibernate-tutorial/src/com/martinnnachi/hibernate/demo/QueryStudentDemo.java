package com.martinnnachi.hibernate.demo;

import com.martinnnachi.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass( Student.class )
                .buildSessionFactory();

        // create a session

        try (factory) {
            Session session = factory.getCurrentSession();

            // start a transaction
            session.beginTransaction();

            // query students
            List<Student> theStudents = session.createQuery( "from Student" ).getResultList();

            // display the students
            displayStudents( theStudents );

            // query students: last name= "nnach"
            theStudents = session.createQuery( "from Student s where s.lastName='nnach'" ).getResultList();

            // display the students
            System.out.println("\n\nThe students who have the last name of nnach");
            displayStudents( theStudents );

            // commit transaction
            session.getTransaction().commit();

            System.out.println( "Done!" );

        }
    }

    private static void displayStudents(List<Student> theStudents) {
        for (Student tempStudent : theStudents) {
            System.out.println( tempStudent );
        }
    }
}

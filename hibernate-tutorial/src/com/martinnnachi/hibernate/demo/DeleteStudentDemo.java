package com.martinnnachi.hibernate.demo;

import com.martinnnachi.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass( Student.class )
                .buildSessionFactory();

        // create a session

        try (factory) {
            Session session = factory.getCurrentSession();

            int studentId = 3;


            // start a transaction
            session.beginTransaction();

            // retrieve a student based on the id: primary key
            System.out.println( "\nGetting student with id: " + studentId );
            Student myStudent = session.get( Student.class, studentId );

//            // delete a student
//            System.out.println("Deleting student: " + myStudent);
//            session.delete( myStudent );

            // deleting student with id = 3, a different approach
            System.out.println("Deleting student with id of 4");
            session.createQuery( "delete from Student where id=4" ).executeUpdate();


            // commit a transaction
            session.getTransaction().commit();

            System.out.println( "Done!" );

        }
    }
}

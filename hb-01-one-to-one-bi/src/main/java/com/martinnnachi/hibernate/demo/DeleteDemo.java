package com.martinnnachi.hibernate.demo;

import com.martinnnachi.hibernate.demo.entity.Instructor;
import com.martinnnachi.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass( Instructor.class )
                .addAnnotatedClass( InstructorDetail.class )
                .buildSessionFactory();

        // create a session

        try (factory) {
            Session session = factory.getCurrentSession();

            // start a transaction
            session.beginTransaction();

            // get instructor primary key/id
            int theId = 1;
            Instructor tempInstructor = session.get( Instructor.class, theId );
            System.out.println( "Found the instructor: " + tempInstructor );

            // delete the instructor
            if (tempInstructor != null) {
                System.out.println( "Deleting: " + tempInstructor );
                session.delete( tempInstructor );
            }

            // commit transaction
            session.getTransaction().commit();

            System.out.println( "Done!" );

        }
    }
}

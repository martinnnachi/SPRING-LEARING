package com.martinnnachi.hibernate.demo;

import com.martinnnachi.hibernate.demo.entity.Instructor;
import com.martinnnachi.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass( Instructor.class )
                .addAnnotatedClass( InstructorDetail.class )
                .buildSessionFactory();

        // create a session

        try (factory; Session session = factory.getCurrentSession()) {


            // start a transaction
            session.beginTransaction();

            // get the instructor detail object
            int id = 3;
            InstructorDetail tempInstructorDetail = session.get( InstructorDetail.class, id );

            // print the instructor detail
            System.out.println( "tempInstructorDetail: " + tempInstructorDetail );

            // print the associated instructor
            System.out.println( "the associated instructor: " + tempInstructorDetail.getInstructor() );

            // remove the associated object reference
            // break the bidirectional link
            tempInstructorDetail.getInstructor().setInstructorDetail( null );

            // delete the instructor detail
            System.out.println( "Deleting tempInstructorDetail: " + tempInstructorDetail );
            session.delete( tempInstructorDetail );

            // commit transaction
            session.getTransaction().commit();

            System.out.println( "Done!" );

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

package com.martinnnachi.hibernate.demo;

import com.martinnnachi.hibernate.demo.entity.Course;
import com.martinnnachi.hibernate.demo.entity.Instructor;
import com.martinnnachi.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass( Instructor.class )
                .addAnnotatedClass( InstructorDetail.class )
                .addAnnotatedClass( Course.class )
                .buildSessionFactory();

        // create a session

        try (factory; Session session = factory.getCurrentSession()) {


            // create the objects
            Instructor tempInstructorOne = new Instructor( "Martin", "Nnachi", "nnach@mart.com" );
            InstructorDetail tempInstructorDetailOne = new InstructorDetail( "https://martcodes.com/youtube", "love to code!" );

            Instructor tempInstructorTwo = new Instructor( "Elesie", "Warenya", "warenya@mart.com" );
            InstructorDetail tempInstructorDetailTwo = new InstructorDetail( "https://warenya.com/youtube", "love singing" );

            Instructor tempInstructorThree = new Instructor( "Gloria", "Amiya-Nnachi", "amiya@mart.com" );
            InstructorDetail tempInstructorDetailThree = new InstructorDetail( "https://amiyacodes.com/youtube", "Gospel music!" );

            // associate the objects
            tempInstructorOne.setInstructorDetail( tempInstructorDetailOne );
            tempInstructorTwo.setInstructorDetail( tempInstructorDetailTwo );
            tempInstructorThree.setInstructorDetail( tempInstructorDetailThree );

            // start a transaction
            session.beginTransaction();

            // save the instructors
            //
            // Note this will ALSO save the details object
            // because of CascadeType.ALL

            session.save( tempInstructorOne );
            session.save( tempInstructorTwo );
            session.save( tempInstructorThree );

            // commit transaction
            session.getTransaction().commit();

            System.out.println( "Done!" );

        }
    }
}

package com.martinnnachi.hibernate.demo;

import com.martinnnachi.hibernate.demo.entity.Course;
import com.martinnnachi.hibernate.demo.entity.Instructor;
import com.martinnnachi.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration().configure()
                .addAnnotatedClass( Instructor.class )
                .addAnnotatedClass( InstructorDetail.class )
                .addAnnotatedClass( Course.class )
                .buildSessionFactory();

        // create a session

        try (factory; Session session = factory.getCurrentSession()) {


            // start a transaction
            session.beginTransaction();

            // hibernate query with HQL

            // get the instructor from db
            int theId = 1;

            Query<Instructor> query = session.createQuery( "select i from Instructor i "
                            + "JOIN FETCH i.courses "
                            + "where i.id=:theInstructorId",
                    Instructor.class );

            // set parameter on query
            query.setParameter( "theInstructorId", theId );

            // execute query and get instructor
            Instructor tempInstructor = query.getSingleResult();

            System.out.println( "martyCodes: Instructor: " + tempInstructor );


            // commit transaction
            session.getTransaction().commit();

            // close session
            session.close();

            System.out.println( "\nmartCodes: Courses: " + tempInstructor.getCourses() );

            System.out.println( "Done!" );

        }
    }
}

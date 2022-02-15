package com.martinnnachi.hibernate.demo;

import com.martinnnachi.hibernate.demo.entity.Course;
import com.martinnnachi.hibernate.demo.entity.Instructor;
import com.martinnnachi.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorCoursesDemo {

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

            // get the instructor from db
            int theId = 1;
            Instructor tempInstructor = session.get( Instructor.class, theId );

            System.out.println( "Instructor: " + tempInstructor );

            // get courses for the instructor
            System.out.println( "Courses: " + tempInstructor.getCourses() );


            // commit transaction
            session.getTransaction().commit();

            System.out.println( "Done!" );

        }
    }
}

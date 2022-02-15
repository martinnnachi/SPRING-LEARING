package com.martinnnachi.hibernate.demo;

import com.martinnnachi.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeletePacmanCourseDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration().configure()
                .addAnnotatedClass( Instructor.class )
                .addAnnotatedClass( InstructorDetail.class )
                .addAnnotatedClass( Course.class )
                .addAnnotatedClass( Review.class )
                .addAnnotatedClass( Student.class )
                .buildSessionFactory();

        // create a session

        try (factory; Session session = factory.getCurrentSession()) {


            // start a transaction
            session.beginTransaction();

            // get the pacman course from db
            int courseId = 10;
            Course tempCourse = session.get( Course.class, courseId );

            // delete the course
            System.out.println( "Deleting course: " + tempCourse );
            session.delete( tempCourse );

            // commit transaction
            session.getTransaction().commit();

            System.out.println( "Done!" );

        }
    }
}

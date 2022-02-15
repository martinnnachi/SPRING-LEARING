package com.martinnnachi.hibernate.demo;

import com.martinnnachi.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentsDemo {

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

            // create the course
            Course tempCourse = new Course( "Pacman - How to Score One Million Points!" );
            Course tempCourse2 = new Course( "Java - The language of the future" );

            // create the students
            Student tempStudent1 = new Student( "John", "Doe", "john@martycodes.com" );
            Student tempStudent2 = new Student( "Mary", "Public", "mary@martycodes.com" );

            // add the students to the course
            tempCourse.addStudents( tempStudent1 );
            tempCourse.addStudents( tempStudent2 );
            tempCourse2.addStudents( tempStudent2 );

            // save the students
            System.out.println( "\nSaving students..." );
            session.save( tempStudent1 );
            session.save( tempStudent2 );


            System.out.println( "\nSaving the courses..." );
            session.save( tempCourse );
            session.save( tempCourse2 );
            System.out.println( "Saved the courses: " + tempStudent1.getCourses() + "\n" + tempStudent2.getCourses() );

            // commit transaction
            session.getTransaction().commit();

            System.out.println( "Done!" );

        }
    }
}

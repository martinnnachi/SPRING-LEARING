package com.martinnnachi.hibernate.demo;

import com.martinnnachi.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesForJohnDemo {

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

            // get the student John from database
            int studentId = 1;
            Student tempStudent = session.get( Student.class, studentId );

            System.out.println( "\nLoaded student: " + tempStudent );
            System.out.println( "Course: " + tempStudent.getCourses() );

            // create more courses
            Course tempCourse1 = new Course( "Rubik's Cube - How to Speed Cube" );
            Course tempCourse2 = new Course( "Atari 2600 - Game Development" );

            // add student to courses
            tempCourse1.addStudents( tempStudent );
            tempCourse2.addStudents( tempStudent );

            // save the courses
            System.out.println( "\nSaving the courses ..." );
            session.save( tempCourse1 );
            session.save( tempCourse2 );


            // commit transaction
            session.getTransaction().commit();

            System.out.println( "Done!" );

        }
    }
}

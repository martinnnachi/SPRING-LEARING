package com.martinnnachi.hibernate.demo;

import com.martinnnachi.hibernate.demo.entity.Course;
import com.martinnnachi.hibernate.demo.entity.Instructor;
import com.martinnnachi.hibernate.demo.entity.InstructorDetail;
import com.martinnnachi.hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewsDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration().configure()
                .addAnnotatedClass( Instructor.class )
                .addAnnotatedClass( InstructorDetail.class )
                .addAnnotatedClass( Course.class )
                .addAnnotatedClass( Review.class )
                .buildSessionFactory();

        // create a session

        try (factory; Session session = factory.getCurrentSession()) {


            // start a transaction
            session.beginTransaction();

            // create the course
            Course tempCourse = new Course( "Pacman - How to Score One Million Points!" );
            Course tempCourse2 = new Course( "Java - The language of the future" );

            // add some reviews
            tempCourse.addReview( new Review( "Great course!... Loved it!" ) );
            tempCourse.addReview( new Review( "Very enjoyable!" ) );
            tempCourse.addReview( new Review( "Looking forward to more" ) );
            tempCourse.addReview( new Review( "Average...at best!" ) );

            tempCourse2.addReview2( "i think the course was okay" );

            // save the course ... and leverage the cascade all
            System.out.println( "Saving the course" );
            System.out.println( tempCourse );
            System.out.println( tempCourse.getReviews() );
            System.out.println( "\n" + tempCourse2 );
            System.out.println( tempCourse2.getReviews() );

            session.save( tempCourse );
            session.save( tempCourse2 );

            // commit transaction
            session.getTransaction().commit();

            System.out.println( "Done!" );

        }
    }
}

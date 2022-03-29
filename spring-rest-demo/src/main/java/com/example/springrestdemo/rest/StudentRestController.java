package com.example.springrestdemo.rest;

import com.example.springrestdemo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    // define @PostConstruct to load the student data only once
    @PostConstruct
    public void loadData() {
        students = new ArrayList<>();

        students.add( new Student( "Martin", "Nnachi" ) );
        students.add( new Student( "Gloria", "Nnachi" ) );
        students.add( new Student( "Edinam", "Gbormittah" ) );

    }

    // define an endpoint for /students - return a list of students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    // define endpoint for /students/{studentId} - return student by index

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        // index into the list

        // check the studentId against the list size
        if ((studentId >= students.size()) || (studentId < 0)) {
            throw new StudentNotFoundException( "Student ID not found: " + studentId );
        }
        return students.get( studentId );
    }

}




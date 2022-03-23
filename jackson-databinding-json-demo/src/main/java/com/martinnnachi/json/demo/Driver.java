package com.martinnnachi.json.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Arrays;

public class Driver {

    public static void main(String[] args) {
        try {
            // create the object mapper
            ObjectMapper mapper = new ObjectMapper();


            // read JSON fila and map/convert to Java POJO: data/sample-lite.json
            Student theStudent = mapper.readValue( new File( "data/sample-full.json" ), Student.class );

            // print first name and last name
            System.out.println("Firstname: " + theStudent.getFirstName());
            System.out.println("LastName: " + theStudent.getLastName());

            Address tempAddress = theStudent.getAddress();
            System.out.println("Street: " + tempAddress.getStreet());
            System.out.println("City: " + tempAddress.getCity());

            System.out.println();

            for (String tempLang : theStudent.getLanguages()) {
                System.out.println(tempLang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

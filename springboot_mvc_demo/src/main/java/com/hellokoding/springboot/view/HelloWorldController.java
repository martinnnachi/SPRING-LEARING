package com.hellokoding.springboot.view;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {

    // Need a controller method to show the initial HTML form

    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    // Need c controller method to process the HTML form

    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    // new controller method to read form data
    // add data to the model

    @RequestMapping("/processFormVersionTwo")
    public String shout(HttpServletRequest request, Model model) {

        // read the request parameter from HTML form
        String theName = request.getParameter( "studentName" );

        // convert the data to all caps
        theName = theName.toUpperCase();

        // create the message
        String result = "Yo! " + theName;

        // add message to the model
        model.addAttribute( "message", result );

        return "helloworld";
    }


}

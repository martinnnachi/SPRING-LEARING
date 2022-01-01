package com.martinnnachi.springboot.application.view;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    // Need a controller method to show the initial HTML form
    @RequestMapping("/showForm")
    public String showForm() {
        return "helloWorld-form";
    }

    // Need c controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloWorld";
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
        String result = "Yo " + theName + "!";

        // add message to the model
        model.addAttribute( "message", result );

        return "helloWorld";
    }

    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {

        // convert the data to all caps
        theName = theName.toUpperCase();

        // create the message
        String result = "Hey " + theName + " from v3!";

        // add message to the model
        model.addAttribute( "message", result );

        return "helloWorld";
    }


}

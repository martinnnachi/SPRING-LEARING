package com.mnnachi.springboot.thymeleafdemo.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
}

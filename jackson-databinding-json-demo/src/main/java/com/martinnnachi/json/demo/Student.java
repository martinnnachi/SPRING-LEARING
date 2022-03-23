package com.martinnnachi.json.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {

    private int id;
    private String firstName;
    private String lastName;
    private boolean active;
    private Address address;

    private String[] languages;


}

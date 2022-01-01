package com.martinnnachi.springboot.application.view;

import java.util.LinkedHashMap;

public class Student {

    private String firstName;
    private String lastName;
    private String country;
    private String favouriteLanguage;
    private String[] operatingSystems;

    private final LinkedHashMap<String, String> countryOptions;
    private final LinkedHashMap<String, String> favouriteLanguageOptions;

    public Student() {
        // Populate country options; used ISO country code
        countryOptions = new LinkedHashMap<>();

        countryOptions.put( "UK", "United Kingdom" );
        countryOptions.put( "USA", "United States of America" );
        countryOptions.put( "NGR", "Nigeria" );
        countryOptions.put( "FRA", "France" );
        countryOptions.put( "GER", "Germany" );

        favouriteLanguageOptions = new LinkedHashMap<>();

        favouriteLanguageOptions.put( "Java", "Java" );
        favouriteLanguageOptions.put( "C#", "C#" );
        favouriteLanguageOptions.put( "Python", "Python" );
        favouriteLanguageOptions.put( "Swift", "Swift" );
        favouriteLanguageOptions.put( "Javascript", "Javascript" );
        favouriteLanguageOptions.put( "Kotlin", "Kotlin" );
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LinkedHashMap<String, String> getCountryOptions() {
        return countryOptions;
    }

    public String getFavouriteLanguage() {
        return favouriteLanguage;
    }

    public void setFavouriteLanguage(String favouriteLanguage) {
        this.favouriteLanguage = favouriteLanguage;
    }

    public LinkedHashMap<String, String> getFavouriteLanguageOptions() {
        return favouriteLanguageOptions;
    }

    public String[] getOperatingSystems() {
        return operatingSystems;
    }

    public void setOperatingSystems(String[] operatingSystems) {
        this.operatingSystems = operatingSystems;
    }
}

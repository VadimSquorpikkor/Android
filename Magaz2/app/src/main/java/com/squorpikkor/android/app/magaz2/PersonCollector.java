package com.squorpikkor.android.app.magaz2;

import java.util.ArrayList;

 // Created by SquorpikkoR on 18.10.2016.

public class PersonCollector {

    private static ArrayList<Person> persons = new ArrayList<>();

    public static ArrayList<Person> getPersons() {
        return persons;
    }

    public static void createPerson(String name){
        persons.add(new Person(name));
    }

    public void loadPerson() {

    }

    public void savePerson() {

    }
}

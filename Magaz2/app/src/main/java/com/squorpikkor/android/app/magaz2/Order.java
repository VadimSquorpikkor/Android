package com.squorpikkor.android.app.magaz2;

import java.util.ArrayList;

public class Order {
    private ArrayList<Person> persons = new ArrayList<>();
    private double personsTotalPrice;
    private double orderPrice;//product price + juice price
    private int juiceQuantity;
    private double invoiceSum;
    private double orderMoneyLeft;

    public void createPerson(String name){
        persons.add(new Person(name));
    }

    public double personsTotalPrice() {
        for (Person person:persons) {
            personsTotalPrice += person.priceSum();
        }
        return personsTotalPrice;
    }

}


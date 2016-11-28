package com.squorpikkor.android.app.magaz2;

import java.util.ArrayList;

 //Created by SquorpikkoR on 18.10.2016.

public class Person {
    /*SharedPreferences sharedPref;
    final String SAVED_TEXT = "saved_" + "name";

    public void Save() {
        sharedPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sharedPref.edit();
        ed.putString(SAVED_TEXT, name);
        ed.commit();
        //Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
    }

    public void load() {
        sharedPref = getPreferences(MODE_PRIVATE);
        String savedText = sharedPref.getString(SAVED_TEXT, "");
        name = savedText;
    }*/

    private String name;
    private ArrayList<Juice> juices = new ArrayList<>();
    private ArrayList<Bonus> bonuses = new ArrayList<>();
    private double money;
    private double allOrdersSum;
    private double moneyLeft;
    private boolean allDone;


    public Person(String name) {
        this.name = name;
    }

    //region GETTERS & SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Juice> getJuices() {
        return juices;
    }

    public void setJuices(ArrayList<Juice> juices) {
        this.juices = juices;
    }

    public ArrayList<Bonus> getBonuses() {
        return bonuses;
    }

    public void setBonuses(ArrayList<Bonus> bonuses) {
        this.bonuses = bonuses;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getMoneyLeft() {
        return moneyLeft;
    }

    public void setMoneyLeft(double moneyLeft) {
        this.moneyLeft = moneyLeft;
    }

    public boolean isAllDone() {
        return allDone;
    }

    public void setAllDone(boolean allDone) {
        this.allDone = allDone;
    }
    //endregion

    public void addJuice(String name, int quantity) {
        juices.add(new Juice(name, quantity));
    }

    public void addProduct(String name, int quantity) {
        bonuses.add(new Bonus(name, quantity));
    }

    public double priceSum() {
        double priceSum = 0;
        for (Juice juice:juices) {
            priceSum += juice.getPrice()*juice.getQuantity();
        }
        for (Bonus bonus : bonuses) {
            priceSum += bonus.getPrice()* bonus.getQuantity();
        }
        return priceSum;
    }


}

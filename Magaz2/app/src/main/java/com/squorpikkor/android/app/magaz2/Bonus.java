package com.squorpikkor.android.app.magaz2;

/**
 * Created by SquorpikkoR on 18.10.2016.
 */
public class Bonus extends Food{
    public Bonus(String name, int price, int quantity) {
        super(name, price, quantity);
    }

    public Bonus(String name, int quantity) {
        super(name, quantity);
    }
}

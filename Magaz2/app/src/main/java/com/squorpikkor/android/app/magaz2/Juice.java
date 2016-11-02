package com.squorpikkor.android.app.magaz2;

/**
 * Created by SquorpikkoR on 18.10.2016.
 */
public class Juice extends Food {
    public Juice(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    public Juice(String name, int quantity) {
        super(name, quantity);
    }
}

package com.squorpikkor.android.app.magaz2;

/**
 * Created by SquorpikkoR on 18.10.2016.
 */
public class Product extends Food{
    public Product(String name, int price, int quantity) {
        super(name, price, quantity);
    }

    public Product(String name, int quantity) {
        super(name, quantity);
    }
}

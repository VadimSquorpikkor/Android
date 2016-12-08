package magaz15.app.android.squorpikkor.com.magaz15;

 //Created by SquorpikkoR on 03.12.2016.

public class Juice {
    private double price;
    private int quantity;
    private double totalPrice = price * quantity;

    /*public Juice(double price, int quantity) {//Need constructor without parameters
        this.price = price;
        this.quantity = quantity;
    }*/

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }


}

package magaz15.app.android.squorpikkor.com.magaz15;

import java.util.ArrayList;

 // Created by SquorpikkoR on 04.12.2016.

public class PriceCalculator {
    public static double calculatePrice(ArrayList<Juice> arrayList) {
        double result = 0;
        for(int i = 0; i<arrayList.size(); i++ ) {
            result = result + arrayList.get(i).getTotalPrice();
        }
        return result;
    }
}

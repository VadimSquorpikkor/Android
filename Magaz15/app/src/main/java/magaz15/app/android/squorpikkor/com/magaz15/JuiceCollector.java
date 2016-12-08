package magaz15.app.android.squorpikkor.com.magaz15;

import java.util.ArrayList;

 //Created by SquorpikkoR on 03.12.2016.

public class JuiceCollector {

    public JuiceCollector(int strokeQuan) {
        for(int i = 0; i<strokeQuan; i++) {
            juiceList.add(new Juice());
        }
    }

    ArrayList<Juice> juiceList = new ArrayList<>();

    /*double priceSummator() {//remove to other class

        return result;
    }*/
}

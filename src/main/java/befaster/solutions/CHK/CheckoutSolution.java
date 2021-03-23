package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

import java.util.HashMap;
import java.util.Hashtable;

public class CheckoutSolution {

    class SkuValue {
        String ident;
        int value;
        int multiplier;
        int special_value;

        public SkuValue(String ident, int value, int multiplier, int special_value) {
            this.ident = ident;
            this.value = value;
            this.multiplier = multiplier;
            this.special_value = special_value;
        }
    }

    Hashtable<String, SkuValue> priceTable = new Hashtable<>(); // overkill for this, but for larger stuff ok

    public CheckoutSolution()
    {
        priceTable.put("A", new SkuValue("A", 50, 3, 130));
        priceTable.put("A", new SkuValue("B", 30, 2, 45));
        priceTable.put("A", new SkuValue("C", 20, 3, 130));
        priceTable.put("A", new SkuValue("A", 50, 3, 130));
    }

    public Integer checkout(String skus) {
        // assume skus of form "ABBCD"
        // assume skus of form "A B B C D"
        // assume skus of form  "A,B,C,D"
        // assume skus of form  "A;B;C"



        String items[];
        HashMap<String, Integer> item_cnt = new HashMap<>(); // overkill for current example

        if (skus.indexOf(" ") > 0) items = skus.split(" ");
        else if (skus.indexOf(",") > 0) items = skus.split(",");
        else if (skus.indexOf(";") > 0) items = skus.split(";");
        else {
            items = new String[skus.length()];
            for (int i = 0; i < skus.length(); i++)
                items[i] = "" + skus.charAt(i);
        }

        for (int i = 0; i < items.length; i++) {
            Integer cnt = item_cnt.get(items[i]);
            if (cnt == null) item_cnt.put(items[i], 0);
            else item_cnt.put(items[i], cnt + 1);
        }



    }
}






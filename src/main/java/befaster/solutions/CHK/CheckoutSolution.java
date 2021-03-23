package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

import java.util.HashMap;
import java.util.Hashtable;

public class CheckoutSolution {

    class SkuValue {
        String ident; // only for convenience; not used
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

    Hashtable<String, SkuValue> priceTable = new Hashtable<>(); // overkill for this, but for for large number of items

    public CheckoutSolution() {
        priceTable.put("A", new SkuValue("A", 50, 3, 130));
        priceTable.put("B", new SkuValue("B", 30, 2, 45));
        priceTable.put("C", new SkuValue("C", 20, -1, 0));
        priceTable.put("D", new SkuValue("D", 15, -1, 0));
    }

    public Integer checkout(String skus) {
        // assume skus of form "ABBCD" ?
        // assume skus of form "A B B C D" ?
        // assume skus of form  "A,B,C,D" ?
        // assume skus of form  "A;B;C" ?

        // PARSE INPUT
        String items[];
        HashMap<String, Integer> item_cnt = new HashMap<>(); // overkill for current example, but ok for large number of items

        if (skus.indexOf(",") > 0) items = skus.split("\\W+,\\W+");
        else if (skus.indexOf(";") > 0) items = skus.split(";\\W+");
        if (skus.indexOf(" ") > 0) items = skus.split("\\W+");
        else {
            items = new String[skus.length()];
            for (int i = 0; i < skus.length(); i++)
                items[i] = "" + skus.charAt(i);
        }

        for (int i = 0; i < items.length; i++) {
            Integer cnt = item_cnt.get(items[i]);
            if (cnt == null) item_cnt.put(items[i], 1);
            else item_cnt.put(items[i], cnt + 1);
        }

        //COMPUTE
        int total = 0;
        for (String key : item_cnt.keySet())
        {
            SkuValue item = priceTable.get(key);
            int count = item_cnt.get(key);
            if (item == null) return -1;
            if (item.multiplier != -1)
                total += (count / item.multiplier) * item.special_value + (count % item.multiplier) * item.value;
            else
                total += count * item.value;
        }

        return total;
    }

    public static void main(String[] args) {
        //do some quick tests inline here
        System.out.println(new CheckoutSolution().checkout("AABCDBAA"));
        System.out.println(new CheckoutSolution().checkout("A,  A,B,C,D,B,A,A"));
        System.out.println(new CheckoutSolution().checkout("A;A;  B;C;D;B;A;A"));
        System.out.println(new CheckoutSolution().checkout("A A  B C D B    A A"));
    }
}

package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

import java.util.HashMap;
import java.util.Hashtable;

public class CheckoutSolution {

    class Combo {
        int multiplier;
        int special_value;
        String otherItem;

        public Combo(int multiplier, int special_value, String otherItem) {
            this.multiplier = multiplier;
            this.special_value = special_value;
            this.otherItem = otherItem;
        }
    }

    class SkuValue {
        int value;
        Combo combos[];

        public SkuValue(int value, Combo combos[]) {
            this.value = value;
            this.combos = combos;
        }
    }

    Hashtable<String, SkuValue> priceTable = new Hashtable<>(); // overkill for this, but for for large number of items

    public CheckoutSolution() {
        priceTable.put("A", new SkuValue(50, new Combo[]{new Combo(5, 200, null), new Combo(3, 130, null),})); // init from high to low count
        priceTable.put("B", new SkuValue(30, new Combo[]{new Combo(2, 45, null)}));
        priceTable.put("C", new SkuValue(20, null));
        priceTable.put("D", new SkuValue(15, null));
        priceTable.put("E", new SkuValue(40, new Combo[]{new Combo(2, -1, "B")}));
        priceTable.put("F", new SkuValue(10, new Combo[]{new Combo(2, -1, "F")}));
    }

    public Integer checkout(String skus) {
        // assume skus of form "ABBCD" ?
        // assume skus of form "A B B C D" ?
        // assume skus of form  "A,B,C,D" ?
        // assume skus of form  "A;B;C" ?

        // PARSE INPUT
        String items[];
        HashMap<String, Integer> item_cnt = new HashMap<>();

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

        // 2 pass algorithm; first apply only rule of kind "2E get one B free"
        for (String key : item_cnt.keySet())
        {
            SkuValue item = priceTable.get(key);
            if (item == null) return -1;
            if (item.combos == null) continue;

            int count = item_cnt.get(key);
            for (int i = 0; i < item.combos.length; i++)
            {
                if (item.combos[i].otherItem != null)
                {
                    String otherItem = item.combos[i].otherItem;
                    int multiplier = item.combos[i].multiplier;
                    int free_cnt = 0;

                    if (otherItem.equals(key)) {
                        if ((count / (multiplier + 1)) == 0) free_cnt = 0;
                        free_cnt = count - ((count / (multiplier + 1)) * (multiplier + 1));
                    }
                    else {
                        free_cnt = count / multiplier;
                    }

                    if (free_cnt == 0) continue;
                    Integer prev_count = item_cnt.get(otherItem);
                    if (prev_count == null) prev_count = 0;
                    int new_cnt = prev_count - free_cnt;
                    if (new_cnt < 0) new_cnt = 0;
                    item_cnt.put(otherItem, new_cnt);
                }
            }
        }

        for (String key : item_cnt.keySet())
        {
            SkuValue item = priceTable.get(key);
            if (item == null) return -1;

            int count = item_cnt.get(key);
            if (item.combos != null)  {
                for (int i = 0; i < item.combos.length; i++) {
                    Combo combo = item.combos[i];
                    if (combo.special_value == -1) continue;

                    total += (count / combo.multiplier) * combo.special_value;
                    count = count % combo.multiplier;
                }
            }
            total += count * item.value;
        }

        return total;
    }

}




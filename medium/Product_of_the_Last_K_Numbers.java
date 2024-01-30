package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 1352. Product of the Last K Numbers
 */

public class Product_of_the_Last_K_Numbers {
    class ProductOfNumbers {

        List<Integer> products;

        public ProductOfNumbers() {
            products = new ArrayList<>();
            products.add(1);
        }

        public void add(int num) {
            if (num == 0) {
                products.clear();
                products.add(1);
            } else {
                products.add(products.get(products.size() - 1) * num);
            }
        }

        public int getProduct(int k) {
            if (products.size() <= k) {
                return 0;
            }
            return products.get(products.size() - 1) / products.get(products.size() - 1 - k);
        }
    }
}

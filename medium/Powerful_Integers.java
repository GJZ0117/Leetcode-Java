package medium;

import java.util.*;

/**
 * 970. Powerful Integers
 */

public class Powerful_Integers {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> res = new HashSet<>();
        TreeSet<Integer> setX = new TreeSet<>();
        TreeSet<Integer> setY = new TreeSet<>();

        for (int i = 1; i < bound; i = i * x) {
            if (setX.contains(i)) {
                break;
            } else {
                setX.add(i);
            }
        }
        for (int i = 1; i < bound; i = i * y) {
            if (setY.contains(i)) {
                break;
            } else {
                setY.add(i);
            }
        }

        for (int n1 : setX) {
            for (int n2 : setY) {
                if (n1 + n2 > bound) {
                    break;
                } else {
                    res.add(n1 + n2);
                }
            }
        }

        return new ArrayList<>(res);
    }
}

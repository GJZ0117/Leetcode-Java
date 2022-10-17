package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1046. Last Stone Weight
 */

public class Last_Stone_Weight {

    public static void main(String[] args) {
        int[] stones = {1,3};
        System.out.println(lastStoneWeight(stones));
    }

    public static int lastStoneWeight(int[] stones) {
        List<Integer> list = new ArrayList<>();
        for (int stone : stones) {
            list.add(stone);
        }

        Collections.sort(list);

        while (!(list.size() <= 1)) {
            int len = list.size();
            int y = list.get(len - 1);
            int x = list.get(len - 2);
            list.remove(len - 1);
            list.remove(len - 2);
            if (x != y) { //if x != y, we need to add y-x into list, else we just remove x,y from list
                int newStone = y - x;
                len = list.size(); // len = len - 2
                if (!list.isEmpty()) { //if list is not empty we need to find where to insert new stone
                    if (newStone >= list.get(len - 1)) { //if new stone's weight is heaver than the heavest stone in list, insert new stone to the last
                        list.add(len, newStone);
                    } else { //find where to insert new stone [0, len-1]
                        for (int i = 0; i < len; i++) {
                            if (list.get(i) >= newStone) {
                                list.add(i, newStone);
                                break;
                            }
                        }
                    }
                } else { //list is empty, just need to insert new stone into list
                    list.add(newStone);
                }
            }
        }
        return list.size() == 1 ? list.get(0) : 0;
    }

}

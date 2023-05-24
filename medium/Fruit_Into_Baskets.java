package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 904. Fruit Into Baskets
 */

public class Fruit_Into_Baskets {
    // https://leetcode.cn/problems/fruit-into-baskets/solution/by-ac_oier-skgk/1799174
    /**
     * 窗口left...right,为可以获得的最大水果数目,用一个哈希表记录每种水果以及对应的水果数目.
     *     右指针每次遍历时,将当前水果加入哈希表中
     *     判断哈希表中总共水果种类(map.size)是否大于2,如果大于2将左指针指向的水果数量-1,并且如果数量为0的话,就将水果从哈希表中移除
     *     返回左右指针间隔(即为最大可获得的水果数目)
     * 思路
     *     窗口内水果不一定符合当前条件,但整体上是最优解;
     *     如果窗口内水果符合条件,则右指针+1,左指针不动,如果不符合条件,左右指针一起移动,即可满足窗口一直处于最优解的状态下.
     * 优势:不用实时计算最大数目,最后直接返回窗口大小即可
     */
    public int totalFruit(int[] fruits) {
        int left = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < fruits.length; i++) {
            map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);
            if (map.size() > 2) {
                int count = map.get(fruits[left]);
                if (count == 1) {
                    map.remove(fruits[left]);
                } else {
                    map.put(fruits[left], count - 1);
                }
                left++;
            }
        }
        return fruits.length - left;
    }
}

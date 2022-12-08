package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 382. Linked List Random Node
 */

public class Linked_List_Random_Node {
    class Solution {

        List<Integer> list;
        Random random;

        public Solution(ListNode head) {
            random = new Random();
            list = new ArrayList<>();
            while (head != null) {
                list.add(head.val);
                head = head.next;
            }
        }

        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }
}

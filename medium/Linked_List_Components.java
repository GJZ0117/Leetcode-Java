package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 817. Linked List Components
 */

public class Linked_List_Components {
    public int numComponents(ListNode head, int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        boolean flag = false;
        while (head != null) {
            if (set.contains(head.val)) {
                flag = true;
            } else {
                if (flag) {
                    ans++;
                    flag = false;
                }
            }
            head = head.next;
        }
        if (flag) {
            ans++;
        }
        return ans;
    }
}

package medium;

import java.util.*;

/**
 * 373. Find K Pairs with Smallest Sums
 */

public class Find_K_Pairs_with_Smallest_Sums {

    public static void main(String[] args) {
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;
        List<List<Integer>> lists = kSmallestPairs(nums1, nums2, k);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    /**
     * eg: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
     * [index1, index2] means nums1's index and nums2's index
     * <p>
     * [0, 0] -> [0, 1] -> [0, 2]
     * |
     * V
     * [1, 0] -> [1, 1] -> [1, 2]
     * |
     * V
     * [2, 0] -> [2, 1] -> [2, 2]
     */

    // https://leetcode.cn/problems/find-k-pairs-with-smallest-sums/solution/tong-ge-lai-shua-ti-la-you-xian-ji-dui-l-fw7y/
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> nums1[a[0]] + nums2[a[1]] - (nums1[b[0]] + nums2[b[1]]));
        // put all nums1's indexes into heap, nums2's indexes are all 0 (to optimize at most put k times [index1, 0])
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            heap.offer(new int[]{i, 0});
        }
        // at most pop k times
        List<List<Integer>> ans = new ArrayList<>();
        while (k-- > 0 && !heap.isEmpty()) {
            // get the heap top, which represents the minium sum of the total heap
            int[] pos = heap.poll();
            ans.add(Arrays.asList(nums1[pos[0]], nums2[pos[1]]));
            // if pos[1] + 1 is still smaller than nums2's length, try to put it into heap
            if (++pos[1] < nums2.length) {
                heap.offer(pos);
            }
        }
        return ans;
    }

    // Time Limit Exceeded
    public static List<List<Integer>> _kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                if (map.containsKey(sum)) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    map.get(sum).add(temp);
                } else {
                    List<List<Integer>> lists = new ArrayList<>();
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    lists.add(temp);
                    map.put(sum, lists);
                }
            }
        }

        List<Integer> keyLists = new ArrayList<>(map.keySet());
        Collections.sort(keyLists);
        List<List<Integer>> ans = new LinkedList<>();
        int listsIndex = 0;
        while (k > 0) {
            if (listsIndex == keyLists.size()) {
                break;
            }
            List<List<Integer>> lists = map.get(keyLists.get(listsIndex++));
            for (List<Integer> list : lists) {
                if (k == 0) {
                    return ans;
                }
                ans.add(list);
                k--;
            }
        }
        return ans;
    }


    // 二刷(还不会)
    public List<List<Integer>> kSmallestPairs_2(int[] nums1, int[] nums2, int k) {
        // 优先级队列 保存 [index1,index2]
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> nums1[a[0]] + nums2[a[1]] - (nums1[b[0]] + nums2[b[1]]));
        // 把nums1的所有索引入队 nums2索引初始为0
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            heap.add(new int[]{i, 0});
        }
        List<List<Integer>> ans = new ArrayList<>();

        // 最多弹出k次
        while (k > 0 && !heap.isEmpty()) {
            int[] pos = heap.poll();
            ans.add(Arrays.asList(nums1[pos[0]], nums2[pos[1]]));
            // 将 index2加1后入队
            if (pos[1] + 1 < nums2.length) {
                pos[1]++;
                heap.add(pos);
            }
            k--;
        }
        return ans;
    }
}

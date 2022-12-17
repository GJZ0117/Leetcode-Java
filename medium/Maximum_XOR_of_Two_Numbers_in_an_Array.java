package medium;

/**
 * 421. Maximum XOR of Two Numbers in an Array
 */

public class Maximum_XOR_of_Two_Numbers_in_an_Array {

    //https://leetcode.cn/problems/maximum-xor-of-two-numbers-in-an-array/solution/java-qian-zhui-shu-tan-xin-by-quruijie-vvn9/
    public int findMaximumXOR(int[] nums) {
        Trie root = new Trie();
        int max = 0;
        for (int num : nums) {
            root.add(num);
            max = Math.max(max, root.findMaxXOR(num));
        }
        return max;
    }

    class Trie {
        Trie[] next = new Trie[2];

        public void add(int num) {
            Trie root = this;
            for (int i = 30; i >= 0; i--) {
                int index = num >> i & 1;
                if (root.next[index] == null) {
                    root.next[index] = new Trie();
                }
                root = root.next[index];
            }
        }


        public int findMaxXOR(int num) {
            Trie root = this;
            int res = 0;
            for (int i = 30; i >= 0; i--) {
                int index = num >> i & 1;
                index ^= 1;
                if (root.next[index] != null) {
                    res |= (1 << i);
                } else {
                    index ^= 1;
                }
                root = root.next[index];
            }
            return res;
        }
    }
}

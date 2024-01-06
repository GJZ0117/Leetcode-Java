package medium;

/**
 * 318. Maximum Product of Word Lengths
 */

public class Maximum_Product_of_Word_Lengths {

    public static void main(String[] args) {
        String[] words = {"a", "aa", "aaa", "aaaa"};
        System.out.println(maxProduct(words));
    }

    // https://leetcode.cn/problems/maximum-product-of-word-lengths/solution/tong-ge-lai-shua-ti-la-zhao-dao-ti-mu-de-y37h/
    public static int maxProduct(String[] words) {
        int ans = 0;
        int[] nums = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                nums[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }
        for (int i = words.length - 1; i >= 1; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if ((nums[i] & nums[j]) == 0) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }


    // 二刷（还不会）
    public int maxProduct_2(String[] words) {
        int n = words.length;
        int index = 0;
        int max = 0;
        int[] flag = new int[n];
        for (String word : words) {
            int temp = 0;
            for (char c : word.toCharArray()) {
                temp |= (1 << c);
            }
            flag[index++] = temp;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if ((flag[i] & flag[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}

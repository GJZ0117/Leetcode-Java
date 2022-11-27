package easy;

/**
 * 459. Repeated Substring Pattern
 */

public class Repeated_Substring_Pattern {
    // https://leetcode.cn/problems/repeated-substring-pattern/solution/jian-dan-ming-liao-guan-yu-javaliang-xing-dai-ma-s/
    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }
}

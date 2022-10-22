package medium;

/**
 * 28. Find the Index of the First Occurrence in a String
 */

public class Find_the_Index_of_the_First_Occurrence_in_a_String {

    public static void main(String[] args) {
        String str1 = "sadbutsad";
        String str2 = "sad";
        System.out.println(strStr(str1, str2));
    }

    public static int strStr(String str1, String str2) {
        int[] next = getNext(str2);
        int index = KMP(str1, str2, next);
        return index;
    }


    public static int KMP(String str1, String str2, int[] next) {
        for (int i = 0, j = 0; i < str1.length(); i++) {
            //需要处理str1.charAt(i)!=str2.charAt(j),去调整j的大小
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if (j == str2.length()) { //找到了
                return i - j + 1;
            }
        }
        return -1;
    }

    public static int[] getNext(String dest) {
        int[] next = new int[dest.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < dest.length(); i++) {
            //当dest.charAt(i)!=dest.charAt(j)时需要从next[j-1]获取新的j,直到dest.charAt(i)==dest.charAt(j)成立才退出
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
            if (dest.charAt(i) == dest.charAt(j)) { //当 dest.charAt(i)==dest.charAt(j)满足时部分匹配值就是+1
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}

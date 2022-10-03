package BasicDataStructure.KMP;


import java.util.Arrays;

public class KMP {

    public static void main(String[] args) {
        String str1 = "BBCABCDABABCDABCDABDE";
        String str2 = "ABCDABD";
        int[] next = getNext(str2);
        System.out.println("next: " + Arrays.toString(next));
        int index = KMP(str1, str2, next);
        System.out.println("index: " + index);
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

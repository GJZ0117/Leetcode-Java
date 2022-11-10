package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Microsoft Compatibility Telemetry
 */

public class Letter_Case_Permutation {
    public static void main(String[] args) {
        String s = "3z4";
        System.out.println(letterCasePermutation(s));
    }

    public static List<String> letterCasePermutation(String s) {
        List<String> list = new ArrayList<>();
        int[][] numAndIndex = new int[s.length()][2]; // (num, index)
        int num = 0; // record how many numbers showed in the string
        StringBuilder letters = new StringBuilder(); // record all the letters showed in the string
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                numAndIndex[num][0] = s.charAt(i) - '0';
                numAndIndex[num][1] = i;
                num++;
            } else {
                letters.append(s.charAt(i));
            }
        }
        generate(list, letters, numAndIndex, num, 0);
        return list;
    }

    //DFS
    public static void generate(List<String> list, StringBuilder letters, int[][] numAndIndex, int num, int start) {
        StringBuilder sb = new StringBuilder(letters);
        for (int i = 0; i < num; i++) {
            int n = numAndIndex[i][0];
            int index = numAndIndex[i][1];
            sb.insert(index, n);
        }
        list.add(sb.toString());
        for (int i = start; i < letters.length(); i++) {
            convertLetter(letters, i);
            generate(list, letters, numAndIndex, num, i + 1);
            convertLetter(letters, i);
        }
    }

    public static void convertLetter(StringBuilder letters, int index) {
        char c = letters.charAt(index);
        if (c >= 'a' && c <= 'z') {
            c -= 32;
        } else {
            c += 32;
        }
        letters.replace(index, index + 1, String.valueOf(c));
    }
}

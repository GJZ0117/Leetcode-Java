package medium;

/**
 * 22. Generate Parentheses
 */

import java.util.ArrayList;
import java.util.List;

public class Generate_Parentheses {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int left = 0, right = 0;
        generate(list, sb, left, right, n);
        return list;
    }
    public static void generate(List<String> list, StringBuilder sb, int left, int right, int n){
        if (sb.length() == 2*n){
            list.add(sb.toString());
            return;
        }
        if (left < n){
            generate(list, sb.append("("), left+1, right, n);
            sb.delete(sb.length()-1, sb.length());
        }
        if (right < left){
            generate(list, sb.append(")"), left, right+1, n);
            sb.delete(sb.length()-1, sb.length());
        }
    }
}

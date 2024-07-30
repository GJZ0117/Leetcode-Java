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

    public static void generate(List<String> list, StringBuilder sb, int left, int right, int n) {
        if (sb.length() == 2 * n) {
            list.add(sb.toString());
            return;
        }
        if (left < n) {
            generate(list, sb.append("("), left + 1, right, n);
            sb.delete(sb.length() - 1, sb.length());
        }
        if (right < left) {
            generate(list, sb.append(")"), left, right + 1, n);
            sb.delete(sb.length() - 1, sb.length());
        }
    }


    // 二刷
    public List<String> generateParenthesis_2(int n) {
        List<String> res = new ArrayList<>();
        recurse(res, 0, 0, new StringBuilder(), n);
        return res;
    }

    private void recurse(List<String> res, int left, int right, StringBuilder sb, int n) {
        if (sb.length() == 2 * n) {
            res.add(sb.toString());
            return;
        }
        if (left < n) {
            recurse(res, left + 1, right, sb.append("("), n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {
            recurse(res, left, right + 1, sb.append(")"), n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


    // 三刷
    public List<String> generateParenthesis_3(int n) {
        List<String> ans = new ArrayList<>();
        dfs("", ans, 0, 0, n);
        return ans;
    }

    public void dfs(String path, List<String> ans, int left, int right, int n) {
        if (left > n || right > left) {
            return;
        }
        if (path.length() == 2 * n) {
            ans.add(path);
            return;
        }
        dfs(path + "(", ans, left + 1, right, n);
        dfs(path + ")", ans, left, right + 1, n);
    }
}

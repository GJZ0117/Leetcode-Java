package medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 71. Simplify Path
 */

public class Simplify_Path {

    public static void main(String[] args) {
        String str = "/home//foo/";
        System.out.println(simplifyPath(str));
    }

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (String str : path.split("/")) {
            if (str.equals("..") && stack.size() != 0) {
                stack.pop();
            } else if (str.equals("..") || str.equals(".")) {
                continue;
            } else if (str.length() > 0) {
                stack.push(str);
            }
        }

        while (!stack.isEmpty()) {
            String str = stack.pop();
            sb.append((new StringBuilder(str).reverse()).toString());
            sb.append("/");
        }

        if (sb.length() == 0) {
            sb.append("/");
        } else {
            sb.reverse();
        }
        return sb.toString();
    }


    // 二刷
    public String simplifyPath_2(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] paths = path.split("/");
        for (String str : paths) {
            if ("..".equals(str) && !stack.isEmpty()) {
                stack.pop();
            } else if ("..".equals(str) || ".".equals(str)) {
                continue;
            } else if (str.length() > 0) {
                stack.push(str);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            String str = stack.pop();
            sb.append((new StringBuilder(str).reverse()));
            sb.append("/");
        }
        if (sb.length() == 0) {
            sb.append("/");
        } else {
            sb.reverse();
        }
        return sb.toString();
    }
}

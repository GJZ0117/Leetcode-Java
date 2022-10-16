package medium;

import java.util.Stack;

/**
 * 394. Decode String
 */

public class Decode_String {

    public static void main(String[] args) {
        System.out.println(decodeString("10[a]"));
    }

    public static String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur != ']') { //if current character is not ']' then push it into stack
                stack.push(cur);
            } else {
                searchOneSection(stack); //if it is '[', then search '[' in stack and construct substring which is in '[' and ']'
            }
        }

        for (Character c : stack) { // the final answer is in stack now
            sb.append(c);
        }
        return sb.toString();
    }

    public static void searchOneSection(Stack<Character> stack) {
        StringBuilder sb = new StringBuilder();
        while (true) { // find last '[' in stack
            char topChar = stack.pop();
            if (topChar != '[') { // construct substring
                sb.append(topChar);
            } else { //found '['
                break;
            }
        }

        sb.reverse(); // the sequence is contrary

        int num = 0; //the repeat num which substring need to push into stack
        int times = 1; //if the final num is over 9, times is what the current num need to be mutiplied by
        char tempChar = stack.pop();
        while (tempChar - '0' >= 0 && tempChar - '0' <= 9) {
            num += (times * (tempChar - '0'));
            times *= 10;

            if (!stack.isEmpty()) { // if the final num is over 9, we need to push next character to check it
                tempChar = stack.pop();
            } else {
                break;
            }
        }

        if (!stack.isEmpty()) { // if stack is not empty, the last pop character is useful and need to be pushed into stack again
            stack.push(tempChar);
        }

        while (num != 0) { //use num and substring to duplicate, push them into stack
            for (int i = 0; i < sb.length(); i++) {
                stack.push(sb.charAt(i));
            }
            num--;
        }
    }
}

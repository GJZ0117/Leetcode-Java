package medium;

/**
 * 640. Solve the Equation
 */

public class Solve_the_Equation {
    public String solveEquation(String equation) {
        String[] strs = equation.split("=");
        String leftStr = strs[0];
        String rightStr = strs[1];
        int leftXNum = 0;
        int rightNum = 0;
        boolean flag = true;
        int index = 0;

        while (index < leftStr.length()) {
            if (leftStr.charAt(index) == '+' || leftStr.charAt(index) == '-') {
                flag = leftStr.charAt(index) == '+';
                index++;
            } else if (leftStr.charAt(index) >= '0' && leftStr.charAt(index) <= '9') {
                int num = 0;
                while (index < leftStr.length() && (leftStr.charAt(index) >= '0' && leftStr.charAt(index) <= '9')) {
                    num = num * 10 + (leftStr.charAt(index) - '0');
                    index++;
                }
                if (index < leftStr.length() && leftStr.charAt(index) == 'x') {
                    leftXNum = flag ? (leftXNum + num) : (leftXNum - num);
                    index++;
                } else {
                    rightNum = flag ? (rightNum - num) : (rightNum + num);
                }
            } else if (leftStr.charAt(index) == 'x') {
                leftXNum = flag ? (leftXNum + 1) : (leftXNum - 1);
                index++;
            }
        }

        index = 0;
        flag = true;
        while (index < rightStr.length()) {
            if (rightStr.charAt(index) == '+' || rightStr.charAt(index) == '-') {
                flag = rightStr.charAt(index) == '+';
                index++;
            } else if (rightStr.charAt(index) >= '0' && rightStr.charAt(index) <= '9') {
                int num = 0;
                while (index < rightStr.length() && (rightStr.charAt(index) >= '0' && rightStr.charAt(index) <= '9')) {
                    num = num * 10 + (rightStr.charAt(index) - '0');
                    index++;
                }
                if (index < rightStr.length() && rightStr.charAt(index) == 'x') {
                    leftXNum = flag ? (leftXNum - num) : (leftXNum + num);
                    index++;
                } else {
                    rightNum = flag ? (rightNum + num) : (rightNum - num);
                }
            } else if (rightStr.charAt(index) == 'x') {
                leftXNum = flag ? (leftXNum - 1) : (leftXNum + 1);
                index++;
            }
        }

        if (leftXNum == 0) {
            if (rightNum == 0) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        }
        int xValue = rightNum / leftXNum;
        return ("x=" + xValue);
    }
}

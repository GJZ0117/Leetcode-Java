package BasicDataStructure.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中缀表达式转后缀表达式
 */
public class PolandNotation {
    public static void main(String[] args) {
        String expression = "1+((2+3)*4)-5";
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println("中缀表达式对应的 List=" + infixExpressionList); //ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]
        List<String> suffixExpreesionList = parseSuffixExpreesionList(infixExpressionList);
        System.out.println("后缀表达式对应的 List" + suffixExpreesionList); //ArrayList [1,2,3,+,4,*,+,5,–]
        System.out.printf("expression=%d", calculate(suffixExpreesionList));
    }

    /**
     * 将中缀表达式对应的List转换为后缀表达式对应的List( [1,+,(,(,2,+,3,),*,4,),-,5] -> [1,2,3,+,4,*,+,5,–])
     */
    public static List<String> parseSuffixExpreesionList(List<String> ls) {
        Stack<String> s1 = new Stack<>(); //符号栈
        List<String> s2 = new ArrayList<>(); // 储存中间结果的 Lists2
        //遍历ls
        for (String item : ls) {
            //如果是一个数则加入s2
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.matches("\\(")) {
                s1.push(item);
            } else if (item.matches("\\)")) { //如果是右括号“)”，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop(); //将(弹出s1栈,消除小括号
            } else {
                //当item的优先级小于等于s1栈顶运算符, 将s1栈顶的运算符弹出并加入到s2中，s1中新的栈顶运算符相比较
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                s1.push(item); //将item压入栈
            }
        }

        //将 s1 中剩余的运算符依次弹出并加入 s2
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        return s2; //按顺序输出就是对应的后缀表达式对应的List
    }

    //将中缀表达式转成对应的 List
    public static List<String> toInfixExpressionList(String s) {
        List<String> ls = new ArrayList<>(); //定义一个 List,存放中缀表达式对应的内容
        int i = 0; //指针用于遍历中缀表达式字符串
        String str; //对多位数的拼接
        char c; //遍历的每一个字符放入c

        while (i < s.length()) {
            //如果c是一个非数字需要加入到ls
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                ls.add("" + c);
                i++;
            } else { //如果是一个数需要考虑多位数
                str = "";
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    str += c;
                    i++;
                }
                ls.add(str);
            }
        }
        return ls;
    }

    /**
     * 将一个逆波兰表达式依次将数据和运算符放入到ArrayList中
     */
    public static List<String> getListString(String suffixExpression) {
        //将 suffixExpression 分割
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }

    /**
     * 完成对逆波兰表达式的运算
     */
    public static int calculate(List<String> ls) {
        // 创建给栈, 只需要一个栈即可
        Stack<String> stack = new Stack<String>();
        // 遍历 ls
        for (String item : ls) {
            // 这里使用正则表达式来取出数
            if (item.matches("\\d+")) { // 匹配的是多位数
                // 入栈
                stack.push(item);
            } else {
                // pop 出两个数，并运算， 再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                //把 res 入栈
                stack.push("" + res);
            }
        }
        //最后留在 stack 中的数据是运算结果
        return Integer.parseInt(stack.pop());
    }
}


//编写一个类 Operation 可以返回一个运算符 对应的优先级
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    //写一个方法，返回对应的优先级数字
    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            case "(":
            case ")":
                break;
            default:
                System.out.println("不存在该运算符");
                break;
        }
        return result;
    }
}

package medium;

/**
 * 537. Complex Number Multiplication
 */

public class Complex_Number_Multiplication {
    public String complexNumberMultiply(String num1, String num2) {
        num1 = num1.substring(0, num1.length() - 1);
        num2 = num2.substring(0, num2.length() - 1);
        String[] str1 = num1.split("\\+");
        String[] str2 = num2.split("\\+");
        int n1 = Integer.parseInt(str1[0]) * Integer.parseInt(str2[0]);
        int n2 = Integer.parseInt(str1[0]) * Integer.parseInt(str2[1]) + Integer.parseInt(str1[1]) * Integer.parseInt(str2[0]);
        int n3 = Integer.parseInt(str1[1]) * Integer.parseInt(str2[1]);
        return (n1 - n3) + "+" + n2 + "i";
    }
}

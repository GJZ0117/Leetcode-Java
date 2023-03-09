package easy;

/**
 * 925. Long Pressed Name
 */

public class Long_Pressed_Name {
        public boolean isLongPressedName(String name, String typed) {
            if (name.length() > typed.length()) {
                return false;
            }
            int nameLeft = 0;
            int nameRight = 0;
            int typedLeft = 0;
            int typedRight = 0;

            while (nameLeft < name.length() && typedLeft < typed.length()) {
                while (nameRight < name.length() && name.charAt(nameLeft) == name.charAt(nameRight)) {
                    nameRight++;
                }
                int sameCharLen = nameRight - nameLeft;
                while (typedRight < typed.length() && typed.charAt(typedLeft) == typed.charAt(typedRight)) {
                    typedRight++;
                }
                if (name.charAt(nameLeft) != typed.charAt(typedLeft) || typedRight - typedLeft < sameCharLen) {
                    return false;
                }
                nameLeft = nameRight;
                typedLeft = typedRight;
            }
            return (nameLeft == name.length() && typedLeft == typed.length());
        }
}

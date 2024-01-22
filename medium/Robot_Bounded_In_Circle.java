package medium;

/**
 * 1041. Robot Bounded In Circle
 */

public class Robot_Bounded_In_Circle {
    public boolean isRobotBounded(String instructions) {
        int direction = 0;
        int[] location = new int[]{0, 0};
        char[] chars = instructions.toCharArray();
        for (char ch : chars) {
            if (ch == 'G') {
                move(location, direction);
            } else if (ch == 'L') {
                direction = (direction + 3) % 4;
            } else if (ch == 'R') {
                direction = (direction + 1) % 4;
            }
        }

        if (direction == 0 && !(location[0] == 0 && location[1] == 0)) {
            return false;
        }
        return true;
    }

    private void move(int[] location, int direction) {
        if (direction == 0) {
            location[1] = location[1] + 1;
        } else if (direction == 1) {
            location[0] = location[0] + 1;
        } else if (direction == 2) {
            location[1] = location[1] - 1;
        } else {
            location[0] = location[0] - 1;
        }
    }
}

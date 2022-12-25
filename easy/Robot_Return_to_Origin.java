package easy;

/**
 * 657. Robot Return to Origin
 */

public class Robot_Return_to_Origin {
    public boolean judgeCircle(String moves) {
        int[] pos = {0, 0};
        for (int i = 0; i < moves.length(); i++) {
            char move = moves.charAt(i);
            if ('U' == move) {
                pos[1]--;
            } else if ('D' == move) {
                pos[1]++;
            } else if ('L' == move) {
                pos[0]--;
            } else if ('R' == move) {
                pos[0]++;
            }
        }
        return (pos[0] == 0) && (pos[1] == 0);
    }
}

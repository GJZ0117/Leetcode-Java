package medium;

/**
 * 789. Escape The Ghosts
 */

public class Escape_The_Ghosts {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int dist = Math.abs(target[0]) + Math.abs(target[1]);
        for (int[] ghost : ghosts) {
            int ghostDist = Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1]);
            if (ghostDist <= dist) {
                return false;
            }
        }
        return true;
    }
}

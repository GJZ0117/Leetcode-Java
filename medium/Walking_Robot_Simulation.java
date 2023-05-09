package medium;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 874. Walking Robot Simulation
 */

public class Walking_Robot_Simulation {

    class pos {
        int x;
        int y;

        public pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            pos pos = (pos) o;
            return x == pos.x &&
                    y == pos.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public int robotSim(int[] commands, int[][] obstacles) {
        Set<pos> set = new HashSet<>(obstacles.length);
        for (int[] obstackle : obstacles) {
            set.add(new pos(obstackle[0], obstackle[1]));
        }
        int direction = 0; // 0 up 1 left 2 down 3 right
        pos p = new pos(0, 0);
        int maxDist = 0;
        for (int n : commands) {
            if (n == -2) {
                direction = (direction + 1 + 4) % 4;
            } else if (n == -1) {
                direction = (direction - 1 + 4) % 4;
            } else {
                if (direction == 0) {
                    while (n > 0) {
                        p.y++;
                        if (set.contains(p)) {
                            p.y--;
                            break;
                        }
                        maxDist = Math.max(maxDist, p.x * p.x + p.y * p.y);
                        n--;
                    }
                } else if (direction == 1) {
                    while (n > 0) {
                        p.x--;
                        if (set.contains(p)) {
                            p.x++;
                            break;
                        }
                        maxDist = Math.max(maxDist, p.x * p.x + p.y * p.y);
                        n--;
                    }
                } else if (direction == 2) {
                    while (n > 0) {
                        p.y--;
                        if (set.contains(p)) {
                            p.y++;
                            break;
                        }
                        maxDist = Math.max(maxDist, p.x * p.x + p.y * p.y);
                        n--;
                    }
                } else {
                    while (n > 0) {
                        p.x++;
                        if (set.contains(p)) {
                            p.x--;
                            break;
                        }
                        maxDist = Math.max(maxDist, p.x * p.x + p.y * p.y);
                        n--;
                    }
                }
            }
        }
        return maxDist;
    }
}

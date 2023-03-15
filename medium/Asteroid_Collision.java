package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 735. Asteroid Collision
 */

public class Asteroid_Collision {
    public int[] asteroidCollision(int[] asteroids) {
        int i = 0;
        List<Integer> towardsLeftList = new ArrayList<>();
        List<Integer> towardsRightList = new ArrayList<>();
        while (i < asteroids.length) {
            if (asteroids[i] > 0) {
                towardsRightList.add(i++);
            } else if (asteroids[i] < 0) {
                towardsLeftList.add(i++);
            }

            while (!towardsLeftList.isEmpty() && !towardsRightList.isEmpty()) {
                int towardsLeftIndex = towardsLeftList.get(towardsLeftList.size() - 1);
                int towardsRightIndex = towardsRightList.get(towardsRightList.size() - 1);
                if (towardsLeftIndex < towardsRightIndex) {
                    break;
                }
                int leftWeight = Math.abs(asteroids[towardsLeftIndex]);
                int rightWeight = Math.abs(asteroids[towardsRightIndex]);
                if (leftWeight > rightWeight) {
                    towardsRightList.remove(towardsRightList.size() - 1);
                } else if (leftWeight < rightWeight) {
                    towardsLeftList.remove(towardsLeftList.size() - 1);
                } else {
                    towardsRightList.remove(towardsRightList.size() - 1);
                    towardsLeftList.remove(towardsLeftList.size() - 1);
                }
            }
        }


        int[] ans;
        if (towardsLeftList.size() == 0 || towardsRightList.size() == 0) {
            ans = new int[Math.max(towardsLeftList.size(), towardsRightList.size())];
            if (towardsLeftList.size() > towardsRightList.size()) {
                for (i = 0; i < towardsLeftList.size(); i++) {
                    ans[i] = asteroids[towardsLeftList.get(i)];
                }
            } else {
                for (i = 0; i < towardsRightList.size(); i++) {
                    ans[i] = asteroids[towardsRightList.get(i)];
                }
            }
        } else {
            ans = new int[towardsLeftList.size() + towardsRightList.size()];
            i = 0;
            int leftIndex = 0;
            int rightIndex = 0;
            while (leftIndex < towardsLeftList.size() && rightIndex < towardsRightList.size()) {
                if (towardsLeftList.get(leftIndex) < towardsRightList.get(rightIndex)) {
                    ans[i++] = asteroids[towardsLeftList.get(leftIndex++)];
                } else {
                    ans[i++] = asteroids[towardsRightList.get(rightIndex++)];
                }
            }
            while (leftIndex != towardsLeftList.size()) {
                ans[i++] = asteroids[towardsLeftList.get(leftIndex++)];
            }
            while (rightIndex != towardsRightList.size()) {
                ans[i++] = asteroids[towardsRightList.get(rightIndex++)];
            }
        }

        return ans;
    }
}

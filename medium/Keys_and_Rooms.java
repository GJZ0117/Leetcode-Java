package medium;

import java.util.*;

/**
 * 841. Keys and Rooms
 */

public class Keys_and_Rooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        int count = 0;
        queue.offer(0);
        while (!queue.isEmpty()) {
            int roomIndex = queue.pollFirst();
            if (!visited[roomIndex]) {
                visited[roomIndex] = true;
                count++;
                List<Integer> keys = rooms.get(roomIndex);
                for (int key : keys) {
                    queue.offer(key);
                }
            }
        }
        return count == n;
    }
}

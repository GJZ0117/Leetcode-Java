package medium;

import java.util.*;

/**
 * 207. Course Schedule
 */

public class Course_Schedule {

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        System.out.println(canFinish(numCourses, prerequisites));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] array = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] req : prerequisites) {
            int targetCourse = req[0];
            int preCourse = req[1];
            array[targetCourse]++;
            if (map.containsKey(preCourse)) {
                map.get(preCourse).add(targetCourse);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(targetCourse);
                map.put(preCourse, list);
            }
        }

        boolean[] visited = new boolean[numCourses];

        while (true) {
            int preCourse = findZero(array, visited, map);
            if (preCourse == -1) {
                break;
            }
            List<Integer> list = map.get(preCourse);
            for (int targetCourse : list) {
                array[targetCourse]--;
            }
        }

        for (int value : array) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }

    public static int findZero(int[] array, boolean[] visited, Map<Integer, List<Integer>> map) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0 && !visited[i] && map.containsKey(i)) {
                visited[i] = true;
                return i;
            }
        }
        return -1;
    }


    // 二刷(还不会)
    public boolean canFinish_2(int numCourses, int[][] prerequisites) {
        int[] array = new int[numCourses];
        boolean[] visited = new boolean[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>((int) ((double) numCourses / 0.75));
        for (int[] arr : prerequisites) {
            array[arr[0]]++;
            if (map.containsKey(arr[1])) {
                map.get(arr[1]).add(arr[0]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(arr[0]);
                map.put(arr[1], list);
            }
        }

        while (true) {
            int preCourse = findZeroPreCourse(array, visited, map);
            if (preCourse == -1) {
                break;
            }
            List<Integer> list = map.get(preCourse);
            for (int i : list) {
                array[i]--;
            }
        }

        for (int val : array) {
            if (val != 0) {
                return false;
            }
        }
        return true;

    }

    public int findZeroPreCourse(int[] array, boolean[] visited, Map<Integer, List<Integer>> map) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0 && !visited[i] && map.containsKey(i)) {
                visited[i] = true;
                return i;
            }
        }
        return -1;
    }


    // 三刷
    public boolean canFinish_3(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjacent = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            adjacent.add(new ArrayList<>());
        }
        for (int[] pair : prerequisites) {
            indegrees[pair[0]]++;
            adjacent.get(pair[1]).add(pair[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.addLast(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.removeFirst();
            numCourses--;
            for (int adj : adjacent.get(cur)) {
                indegrees[adj]--;
                if (indegrees[adj] == 0) {
                    queue.addLast(adj);
                }
            }
        }
        return numCourses == 0;
    }
}

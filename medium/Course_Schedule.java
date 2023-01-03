package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}

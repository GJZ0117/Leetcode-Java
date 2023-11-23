package medium;

import java.util.*;

/**
 * 210. Course Schedule II
 */

public class Course_Schedule_II {

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        System.out.println(Arrays.toString(findOrder(numCourses, prerequisites)));
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
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
        int[] ansOrder = new int[numCourses];
        int index = 0;

        while (true) {
            int preCourse = findZero(array, visited, map);
            if (preCourse == -1) {
                break;
            }
            ansOrder[index++] = preCourse;
            if (map.containsKey(preCourse)) {
                List<Integer> list = map.get(preCourse);
                for (int targetCourse : list) {
                    array[targetCourse]--;
                }
            }
        }

        if (index == numCourses) {
            return ansOrder;
        } else {
            return new int[0];
        }
    }

    public static int findZero(int[] array, boolean[] visited, Map<Integer, List<Integer>> map) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0 && !visited[i]) {
                visited[i] = true;
                return i;
            }
        }
        return -1;
    }


    // 二刷
    public int[] findOrder_2(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int resIndex = 0;
        int[] cnt = new int[numCourses];
        boolean[] visited = new boolean[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] arr : prerequisites) {
            int cur = arr[0];
            int pre = arr[1];
            cnt[cur]++;
            if (map.containsKey(pre)) {
                map.get(pre).add(cur);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(cur);
                map.put(pre, list);
            }
        }

        while (true) {
            int index = findZeroPreIndex(cnt, visited);
            if (index == -1) {
                break;
            }
            res[resIndex++] = index;
            if (map.containsKey(index)) {
                for (int i : map.get(index)) {
                    cnt[i]--;
                }
            }
        }
        return resIndex == numCourses ? res : new int[0];
    }

    private int findZeroPreIndex(int[] cnt, boolean[] visited) {
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == 0 && !visited[i]) {
                visited[i] = true;
                return i;
            }
        }
        return -1;
    }
}

package medium;

import java.util.*;

/**
 * 310. Minimum Height Trees
 */

public class Minimum_Height_Trees {
    // https://leetcode.cn/problems/minimum-height-trees/solution/zui-rong-yi-li-jie-de-bfsfen-xi-jian-dan-zhu-shi-x/
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new LinkedList<>();
        if (n == 1) {
            ans.add(0);
            return ans;
        }
        int[] degree = new int[n]; // record all nodes' degree
        List<List<Integer>> list = new ArrayList<>(); // record all nodes' neighbours
        for (int i = 0; i < n; i++) { // init list
            list.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            degree[edge[0]]++; // set all nodes' degree
            degree[edge[1]]++;
            list.get(edge[0]).add(edge[1]); // set all nodes' neighbours
            list.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>(); // bfs's queue
        for (int i = 0; i < n; i++) { // add all nodes which have one neighbour to queue
            if (degree[i] == 1) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            ans.clear(); // every time clean ans list to save the final answer
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll(); // current node
                ans.add(cur);
                List<Integer> neighbours = list.get(cur);
                for (int neighbour : neighbours) {
                    degree[neighbour]--; // current neighbour's degree minus one, means delete current node from tree
                    if (degree[neighbour] == 1) { // nodes' degree in queue : 1,1,1...,2,2,2...,3,3,3...
                        queue.add(neighbour);
                    }
                }
            }
        }
        return ans;
    }


    // 二刷（还不会）
    public List<Integer> findMinHeightTrees_2(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        // 如果只有一个节点那么他就是最小高度树
        if (n == 1) {
            res.add(0);
            return res;
        }
        // 建立各个节点的出度表
        int[] degree = new int[n];
        // 建立图关系，在每个节点的list中存储相连节点
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        // 建立队列
        Deque<Integer> queue = new ArrayDeque<>();
        // 把所有度为1的节点（叶子节点）入队
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.addLast(i);
            }
        }
        // BFS
        while (!queue.isEmpty()) {
            // 每层循环new一个新的结果集合，最后保存的就是最终的最小高度树
            res = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.pollFirst();
                res.add(cur);
                List<Integer> neighbours = map.get(cur);
                for (int neighbour : neighbours) {
                    degree[neighbour]--;
                    if (degree[neighbour] == 1) {
                        queue.addLast(neighbour);
                    }
                }
            }
        }
        return res;
    }
}

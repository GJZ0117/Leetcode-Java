package medium;

import java.util.*;

/**
 * 863. All Nodes Distance K in Binary Tree
 */

public class All_Nodes_Distance_K_in_Binary_Tree {

    class GraphNode {
        int val;
        List<GraphNode> neighbours = new ArrayList<>();
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, GraphNode> map = new HashMap<>();
        preOrder(root, map);
        if (k == 0) {
            list.add(map.get(target.val).val);
            return list;
        }
        Deque<GraphNode> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[501];
        int level = 0;
        queue.offer(map.get(target.val));
        visited[target.val] = true;
        GraphNode graphNode;
        int len;
        while (!queue.isEmpty()) {
            if (level == k) {
                for (GraphNode node : queue) {
                    list.add(node.val);
                }
                break;
            }
            len = queue.size();
            level++;
            while (len > 0) {
                graphNode = queue.pollFirst();
                for (GraphNode neighbour : graphNode.neighbours) {
                    if (!visited[neighbour.val]) {
                        queue.offer(neighbour);
                        visited[neighbour.val] = true;
                    }
                }
                len--;
            }
        }
        return list;
    }

    private void preOrder(TreeNode root, Map<Integer, GraphNode> map) {
        if (root != null) {
            GraphNode curNode, leftNode, rightNode;

            if (!map.containsKey(root.val)) {
                curNode = new GraphNode();
                curNode.val = root.val;
                map.put(root.val, curNode);
            } else {
                curNode = map.get(root.val);
            }

            if (root.left != null) {
                if (!map.containsKey(root.left.val)) {
                    leftNode = new GraphNode();
                    leftNode.val = root.left.val;
                    map.put(root.left.val, leftNode);
                } else {
                    leftNode = map.get(root.left.val);
                }
                curNode.neighbours.add(leftNode);
                leftNode.neighbours.add(curNode);
            }

            if (root.right != null) {
                if (!map.containsKey(root.right.val)) {
                    rightNode = new GraphNode();
                    rightNode.val = root.right.val;
                    map.put(root.right.val, rightNode);
                } else {
                    rightNode = map.get(root.right.val);
                }
                curNode.neighbours.add(rightNode);
                rightNode.neighbours.add(curNode);
            }

            preOrder(root.left, map);
            preOrder(root.right, map);
        }
    }
}

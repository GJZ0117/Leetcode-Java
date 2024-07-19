package medium;

import java.util.*;

/**
 * 133. Clone Graph
 */

class GraphNode {
    public int val;
    public List<GraphNode> neighbors;

    public GraphNode() {
        val = 0;
        neighbors = new ArrayList<GraphNode>();
    }

    public GraphNode(int _val) {
        val = _val;
        neighbors = new ArrayList<GraphNode>();
    }

    public GraphNode(int _val, ArrayList<GraphNode> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class Clone_Graph {
    public GraphNode cloneGraph(GraphNode node) {
        if (node == null) {
            return null;
        } else if (node.neighbors == null || node.neighbors.size() == 0) {
            return new GraphNode(node.val);
        }
        Set<GraphNode> set = new HashSet<>(); // record all nodes in original graph
        Map<Integer, GraphNode> newMap = new HashMap<>(); // record new generated nodes and their values
        Queue<GraphNode> queue = new LinkedList<>(); // this queue is used to traverse graph by BFS
        queue.add(node);
        while (!queue.isEmpty()) {
            int size = queue.size(); // record every level's node number
            for (int i = 0; i < size; i++) {
                GraphNode p = queue.poll();
                set.add(p);
                GraphNode newNode = new GraphNode(p.val);
                newMap.put(p.val, newNode);
                for (GraphNode n : p.neighbors) {
                    if (!set.contains(n)) {
                        queue.add(n);
                    }
                }
            }
        }

        for (GraphNode cur : set) { // set every new generated node's neighbours
            GraphNode curNode = newMap.get(cur.val);
            for (GraphNode neighbour : cur.neighbors) {
                curNode.neighbors.add(newMap.get(neighbour.val));
            }
        }
        return newMap.get(node.val);
    }


    // 二刷
    public GraphNode cloneGraph_2(GraphNode node) {
        if (node == null) {
            return node;
        }
        Map<Integer, GraphNode> map = new HashMap<>();
        Deque<GraphNode> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[101];
        deque.addLast(node);
        while (!deque.isEmpty()) {
            GraphNode p = deque.removeFirst();
            if (!visited[p.val]) {
                visited[p.val] = true;
                GraphNode newNode = null;
                if (!map.containsKey(p.val)) {
                    newNode = new GraphNode(node.val);
                    map.put(newNode.val, newNode);
                } else {
                    newNode = map.get(p.val);
                }

                for (GraphNode neighbor : p.neighbors) {
                    if (map.containsKey(neighbor.val)) {
                        newNode.neighbors.add(map.get(neighbor.val));
                    } else {
                        GraphNode newNeighbor = new GraphNode(neighbor.val);
                        map.put(newNeighbor.val, newNeighbor);
                        newNode.neighbors.add(newNeighbor);
                    }
                    if (!visited[neighbor.val]) {
                        deque.addLast(neighbor);
                    }
                }
            }
        }
        return map.get(node.val);
    }


    // 三刷
    public GraphNode cloneGraph_3(GraphNode node) {
        if (node == null) {
            return null;
        }
        Map<Integer, GraphNode> map = new HashMap<>();
        Deque<GraphNode> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[101];
        queue.addLast(node);
        while (!queue.isEmpty()) {
            GraphNode cur = queue.removeFirst();
            if (!visited[cur.val]) {
                visited[cur.val] = true;
                GraphNode newNode = null;
                if (!map.containsKey(cur.val)) {
                    newNode = new GraphNode(cur.val);
                    map.put(newNode.val, newNode);
                } else {
                    newNode = map.get(cur.val);
                }

                for (GraphNode neighbour : cur.neighbors) {
                    if (map.containsKey(neighbour.val)) {
                        newNode.neighbors.add(map.get(neighbour.val));
                    } else {
                        GraphNode newNeighbour = new GraphNode(neighbour.val);
                        map.put(neighbour.val, newNeighbour);
                        newNode.neighbors.add(newNeighbour);
                    }
                    if (!visited[neighbour.val]) {
                        queue.add(neighbour);
                    }
                }
            }
        }
        return map.get(node.val);
    }
}

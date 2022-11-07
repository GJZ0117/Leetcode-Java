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
}

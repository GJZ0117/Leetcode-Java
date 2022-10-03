package BasicDataStructure.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    public ArrayList<String> vertexList; //顶点集合
    public int[][] edges; //邻接矩阵
    public int edgeNum; //边数
    public boolean[] isVisited; //记录某个节点是否被访问过

    public static void main(String[] args) {
        int n = 8; //节点数
        Graph graph = new Graph(n);

        String Vertexs[] = {"1", "2", "3", "4", "5", "6", "7", "8"};
        for (String vertex : Vertexs) { //添加节点
            graph.insertVertex(vertex);
        }
        //添加边
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);

        //打印邻接矩阵
        graph.showGraph();

        //深度优先遍历
        System.out.print("\n深度优先遍历: ");
        graph.DFS();
        //广度优先遍历
        System.out.print("\n广度优先遍历: ");
        graph.BFS();
    }

    //构造器初始化
    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        edgeNum = n;
    }

    //插入结点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    //添加边
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        edgeNum++;
    }

    //返回结点 i(下标)对应的数据 0->"A" 1->"B" 2->"C"
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //打印邻接矩阵
    public void showGraph() {
        for (int[] link : edges) {
            System.err.println(Arrays.toString(link));
        }
    }

    //得到第一个邻接结点的下标 w
    public int getFirstNeighour(int index) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    //根据前一个邻接节点的下标获取下一个邻接节点
    public int getNextNeighour(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    //深度优先遍历
    public void DFS() {
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < vertexList.size(); i++) {
            if (!isVisited[i]) {
                DFS(isVisited, i);
            }
        }
    }

    public void DFS(boolean[] isVisited, int i) { //i第一次为0
        System.out.print(getValueByIndex(i) + " "); //访问该节点
        isVisited[i] = true; //将节点设置为已访问
        int w = getFirstNeighour(i); //找到第一个邻接节点w
        while (w != -1) {
            if (!isVisited[w]) { //w节点没被访问过
                DFS(isVisited, w);
            }
            w = getNextNeighour(i, w); //如果w节点已经被访问过
        }
    }

    //广度优先遍历
    public void BFS() {
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < vertexList.size(); i++) {
            if (!isVisited[i]) {
                BFS(isVisited, i);
            }
        }
    }

    public void BFS(boolean[] isVisited, int i) {
        int u; //队列头节点对应下表
        int w; //邻接节点w
        LinkedList queue = new LinkedList();
        System.out.print(getValueByIndex(i) + " "); //访问节点
        isVisited[i] = true; //标记为已访问
        queue.addLast(i); //将节点加入队列
        while (!queue.isEmpty()) {
            u = (Integer) queue.removeFirst(); //取出队列头节点下表
            w = getFirstNeighour(u); //得到第一个邻接节点下表w
            while (w != -1) {
                if (!isVisited[w]) { //w没被访问过
                    System.out.print(getValueByIndex(w) + " ");
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                w = getNextNeighour(u, w); //以u为前驱节点，找w后面的下一个邻接节点
            }

        }
    }
}

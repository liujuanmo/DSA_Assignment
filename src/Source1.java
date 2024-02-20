import java.util.*;

public class Source1 {

    private int vertexCount;
    private static LinkedList<Integer> adj[];

    Source1(int vertexCount) {
        this.vertexCount = vertexCount;
        this.adj = new LinkedList[vertexCount];
        for (int i = 0; i < vertexCount; ++i) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int v, int w) {
        if (!isValidIndex(v) || !isValidIndex(w)) {
            return;
        }
        adj[v].add(w);
        adj[w].add(v);
    }

    private boolean isValidIndex(int i) {
        // Write code here
        // 检查给定的索引是否在有效范围内
        return i >= 0 && i < vertexCount;

    }

    private boolean isCyclic(int v, boolean visited[], int parent) {
        // Write code here
        // 标记当前节点为访问过
        visited[v] = true;

        // 遍历当前节点的所有邻居节点
        for (int neighbor : adj[v]) {
            // 如果邻居节点没有被访问过，则继续递归检查
            if (!visited[neighbor]) {
                if (isCyclic(neighbor, visited, v)) {
                    return true;
                }
            }
            // 如果邻居节点已经被访问过，并且不是当前节点的父节点，则存在环
            else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

    public boolean isTree() {
        // Write Code here
        boolean[] visited = new boolean[vertexCount];

        // 检查图是否是连通的，如果不是，直接返回false
        if (!isConnected(visited)) {
            return false;
        }

        // 检查是否存在环
        if (isCyclic(0, visited, -1)) {
            return false;
        }

        // 如果以上两个条件都满足，则图是一棵树
        return true;
    }

    private boolean isConnected(boolean[] visited) {
        // 从第一个节点开始DFS遍历
        dfs(0, visited);

        // 检查是否所有节点都被访问到
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }

    private void dfs(int v, boolean[] visited) {
        // 标记当前节点为访问过
        visited[v] = true;

        // 遍历当前节点的所有邻居节点
        for (int neighbor : adj[v]) {
            // 如果邻居节点没有被访问过，则继续递归遍历
            if (!visited[neighbor]) {
                dfs(neighbor, visited);
            }
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // Get the number of nodes from the input.
        int noOfNodes =  sc.nextInt();
        // Get the number of edges from the input.
        int noOfEdges = sc.nextInt();

        Source1 graph = new Source1(noOfNodes);
        // Adding edges to the graph
        for (int i = 0; i <noOfEdges; ++i) {
            graph.addEdge(sc.nextInt(),sc.nextInt());
        }
        if (graph.isTree()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
import java.util.*;

// 图的节点类
class GraphNode {
    int val;
    List<GraphNode> neighbors;

    public GraphNode(int val) {
        this.val = val;
        this.neighbors = new ArrayList<>();
    }
}

public class GraphBFS {

    // 广度优先搜索
    public static void bfs(GraphNode node) {
        if (node == null) {
            return;
        }

        Queue<GraphNode> queue = new LinkedList<>();
        Set<GraphNode> visited = new HashSet<>();

        queue.offer(node);
        visited.add(node);

        while (!queue.isEmpty()) {
            GraphNode currNode = queue.poll();
            System.out.print(currNode.val + " ");

            for (GraphNode neighbor : currNode.neighbors) {
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        // 创建图
        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node3);
        node2.neighbors.add(node4);
        node3.neighbors.add(node4);

        System.out.println("BFS结果：");
        bfs(node1);
    }
}

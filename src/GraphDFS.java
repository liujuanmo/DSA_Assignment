import java.util.*;

// 图的节点类
//class GraphNode {
//    int val;
//    List<GraphNode> neighbors;
//
//    public GraphNode(int val) {
//        this.val = val;
//        this.neighbors = new ArrayList<>();
//    }
//}

public class GraphDFS {

    // 递归深度优先搜索
    public static void recursiveDFS(GraphNode node, Set<GraphNode> visited) {
        if (node == null || visited.contains(node)) {
            return;
        }

        visited.add(node);
        System.out.print(node.val + " ");

        for (GraphNode neighbor : node.neighbors) {
            recursiveDFS(neighbor, visited);
        }
    }

    // 迭代深度优先搜索
    public static void iterativeDFS(GraphNode node) {
        if (node == null) {
            return;
        }

        Set<GraphNode> visited = new HashSet<>();
        Stack<GraphNode> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            GraphNode currNode = stack.pop();

            if (!visited.contains(currNode)) {
                visited.add(currNode);
                System.out.print(currNode.val + " ");

                // 将未访问的邻居节点压入栈中
                for (GraphNode neighbor : currNode.neighbors) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
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

        System.out.println("递归DFS结果：");
        recursiveDFS(node1, new HashSet<>());
        System.out.println();

        System.out.println("迭代DFS结果：");
        iterativeDFS(node1);
    }
}

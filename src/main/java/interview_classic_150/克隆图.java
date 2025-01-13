package interview_classic_150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * 133 克隆图
 *
 * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
 * 
 * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 * 
 * class Node {
 * public int val;
 * public List<Node> neighbors;
 * }
 * 
 * 测试用例格式：
 * 
 * 简单起见，每个节点的值都和它的索引相同。例如，第一个节点值为 1（val = 1），第二个节点值为 2（val =
 * 2），以此类推。该图在测试用例中使用邻接列表表示。
 * 
 * 邻接列表 是用于表示有限图的无序列表的集合。每个列表都描述了图中节点的邻居集。
 * 
 * 给定节点将始终是图中的第一个节点（值为 1）。你必须将 给定节点的拷贝 作为对克隆图的引用返回。
 * 
 * 示例 1：
 * 
 * <img src=
 * "https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/02/01/133_clone_graph_question.png"/>
 * 
 * 输入：adjList = [[2,4],[1,3],[2,4],[1,3]]
 * 输出：[[2,4],[1,3],[2,4],[1,3]]
 * 解释：
 * 图中有 4 个节点。
 * 节点 1 的值是 1，它有两个邻居：节点 2 和 4 。
 * 节点 2 的值是 2，它有两个邻居：节点 1 和 3 。
 * 节点 3 的值是 3，它有两个邻居：节点 2 和 4 。
 * 节点 4 的值是 4，它有两个邻居：节点 1 和 3 。
 *
 * 示例 2：
 * 
 * <img src=
 * "https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/02/01/graph.png"/>
 * 
 * 输入：adjList = [[]]
 * 输出：[[]]
 * 解释：输入包含一个空列表。该图仅仅只有一个值为 1 的节点，它没有任何邻居。
 *
 * 示例 3：
 * 
 * 输入：adjList = []
 * 输出：[]
 * 解释：这个图是空的，它不含任何节点。
 * 
 * 提示：
 * 
 * 这张图中的节点数在 [0, 100] 之间。
 * 1 <= Node.val <= 100
 * 每个节点值 Node.val 都是唯一的，
 * 图中没有重复的边，也没有自环。
 * 图是连通图，你可以从给定节点访问到所有节点。
 */
public class 克隆图 {

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }

    }

    public Node arrToNode(int[][] adjList) {
        ArrayList<Node> table = new ArrayList<Node>();
        for (int i = 0; i < adjList.length; i++) {
            table.add(new Node(i + 1));
        }

        for (int i = 0; i < adjList.length; i++) {
            Node node = table.get(i);
            for (int j = 0; j < adjList[i].length; j++) {
                node.neighbors.add(table.get(adjList[i][j] - 1));
            }
        }

        return table.get(0);
    }

    public void printNode(Node node) {
        HashSet<Node> visited = new HashSet<Node>();
        HashSet<Node> unvisited = new HashSet<Node>();
        unvisited.add(node);
        while (!unvisited.isEmpty()) {
            node = unvisited.iterator().next();
            unvisited.remove(node);
            System.out.println("Node: " + node.val);
            node.neighbors.forEach(e -> {
                System.out.println("neighbors: " + e.val + " ");
                if (!visited.contains(e)) {
                    unvisited.add(e);
                    System.out.println("add: " + e.val);
                }
            });
            System.out.println("size: " + unvisited.size());
            System.out.println();
            visited.add(node);
        }
    }

    // 29ms 9.13%
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        Node ans = node;
        HashMap<Node, Node> table = new HashMap<Node, Node>();
        HashSet<Node> visited = new HashSet<Node>();
        HashSet<Node> unvisited = new HashSet<Node>();
        unvisited.add(node);
        while (!unvisited.isEmpty()) {
            node = unvisited.iterator().next();
            unvisited.remove(node);
            visited.add(node);
            Node newnode = new Node(node.val);
            table.put(node, newnode);
            node.neighbors.forEach(e -> {
                if (!visited.contains(e)) {
                    unvisited.add(e);
                }
            });
        }

        table.forEach((key, value) -> {
            key.neighbors.forEach(e -> {
                value.neighbors.add(table.get(e));
            });
        });
        return table.get(ans);

    }

    private HashMap<Node, Node> visited = new HashMap<>();

    // dfs 25ms 85.95%
    public Node cloneGraph2(Node node) {
        if (node == null) {
            return node;
        }

        // 如果该节点已经被访问过了，则直接从哈希表中取出对应的克隆节点返回
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // 克隆节点，注意到为了深拷贝我们不会克隆它的邻居的列表
        Node cloneNode = new Node(node.val, new ArrayList());
        // 哈希表存储
        visited.put(node, cloneNode);

        // 遍历该节点的邻居并更新克隆节点的邻居列表
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }

    // bfs 24ms 100.0%
    public Node cloneGraph3(Node node) {
        if (node == null) {
            return node;
        }

        HashMap<Node, Node> visited = new HashMap();

        // 将题目给定的节点添加到队列
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(node);
        // 克隆第一个节点并存储到哈希表中
        visited.put(node, new Node(node.val, new ArrayList()));

        // 广度优先搜索
        while (!queue.isEmpty()) {
            // 取出队列的头节点
            Node n = queue.remove();
            // 遍历该节点的邻居
            for (Node neighbor : n.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    // 如果没有被访问过，就克隆并存储在哈希表中
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList()));
                    // 将邻居节点加入队列中
                    queue.add(neighbor);
                }
                // 更新当前节点的邻居列表
                visited.get(n).neighbors.add(visited.get(neighbor));
            }
        }

        return visited.get(node);
    }

    @Test
    public void test() {
        int[][] adjList = {
                { 2, 4 }, { 1, 3 }, { 2, 4 }, { 1, 3 }
        };
        // int[][] adjList2 = {
        // { 2 }, { 1 }
        // };
        Node node = arrToNode(adjList);
        Node ans = cloneGraph3(node);
        printNode(ans);
        // System.out.println(node.val);
        // node.neighbors.forEach(e -> System.out.println(e.val));
    }
}

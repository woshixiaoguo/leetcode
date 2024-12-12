package interview_classic_150;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

import ds.TreeNode;

/**
 * 104 二叉树的最大深度
 *
 * 给定一个二叉树 root ，返回其最大深度。
 * 
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 
 * 
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：3
 * 示例 2：
 * 
 * 输入：root = [1,null,2]
 * 输出：2
 * 
 * 
 * 提示：
 * 
 * 树中节点的数量在 [0, 104] 区间内。
 * -100 <= Node.val <= 100
 */

public class 二叉树的最大深度 {

    // 深度优先搜索
    public int maxDepth(TreeNode root) {
        int sum = 0;
        if (root != null) {
            sum++;
            sum += Math.max(maxDepth(root.left), maxDepth(root.right));
        }
        return sum;
    }

    // 广度优先搜索
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }

    @Test
    public void test() {
        Object[] arr = { 3, 9, 20, null, null, 15, 7 };
        TreeNode node = TreeNode.arrToNode(arr);
        TreeNode.print(node);
        int ans = maxDepth(node);
        System.out.println(ans);

    }
}

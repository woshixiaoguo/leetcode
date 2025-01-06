package interview_classic_150;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

import org.junit.Test;

import ds.TreeNode;

/**
 * 230 二叉搜索树中第K小的元素
 *
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。
 * 
 * 示例 1：
 * 
 * <img src="https://assets.leetcode.com/uploads/2021/01/28/kthtree1.jpg"/>
 * 
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 * 
 * 示例 2：
 * 
 * <img src="https://assets.leetcode.com/uploads/2021/01/28/kthtree2.jpg"/>
 * 
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 * 
 * 提示：
 * 
 * 树中的节点数为 n 。
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 * 
 * 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？
 */

public class 二叉搜索树中第K小的元素 {

    ArrayList<Integer> table = new ArrayList<Integer>();

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root);
        return table.get(k - 1);
    }

    public void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        table.add(root.val);
        inOrder(root.right);
    }

    public int kthSmallest2(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            --k;
            if (k == 0) {
                break;
            }
            root = root.right; // 把右子树添加到栈中
        }
        return root.val;
    }

    @Test
    public void test() {
        Object[] root = { 3, 1, 4, null, 2 };
        int k = 1;
        TreeNode node = TreeNode.arrToNode(root);
        int ans = kthSmallest(node, k);
        System.out.println(ans);

    }
}

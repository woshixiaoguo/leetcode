package interview_classic_150;

import org.junit.Test;

import ds.TreeNode;

/**
 * 530 二叉搜索树的最小绝对差
 *
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * 
 * 差值是一个正数，其数值等于两值之差的绝对值。
 * 
 * 示例 1：
 * 
 * <img src="https://assets.leetcode.com/uploads/2021/02/05/bst1.jpg"/>
 * 
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 * 
 * 示例 2：
 * 
 * <img src="https://assets.leetcode.com/uploads/2021/02/05/bst2.jpg"/>
 * 
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 * 
 * 提示：
 * 
 * 树中节点的数目范围是 [2, 104]
 * 0 <= Node.val <= 105
 * 
 * 注意：本题与 783
 * https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同
 */
public class 二叉搜索树的最小绝对差 {

    public int getMinimumDifference(TreeNode root) {
        int ans = Integer.MAX_VALUE;
        if (root == null)
            return ans;
        int left = ans, right = ans;
        if (root.left != null)
            left = Math.abs(root.val - findMax(root.left));
        if (root.right != null)
            right = Math.abs(root.val - findMin(root.right));
        return Math.min(Math.min(left, right),
                Math.min(getMinimumDifference(root.left), getMinimumDifference(root.right)));
    }

    public int findMax(TreeNode root) {
        int ans = Integer.MIN_VALUE;
        if (root == null)
            return ans;
        int left = findMax(root.left);
        int right = findMax(root.right);
        return Math.max(root.val, Math.max(left, right));

    }

    public int findMin(TreeNode root) {
        int ans = Integer.MAX_VALUE;
        if (root == null)
            return ans;
        int left = findMin(root.left);
        int right = findMin(root.right);
        return Math.min(root.val, Math.min(left, right));

    }

    int pre;
    int ans;

    public int getMinimumDifference2(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }

    @Test
    public void test() {
        // Object[] root = { 1, 0, 48, null, null, 12, 49 };
        Object[] root = { 236, 104, 701, null, 227, null, 911 };
        TreeNode node = TreeNode.arrToNode(root);
        int ans = getMinimumDifference(node);
        // int ans = findMin(node);
        System.out.println(ans);

    }
}

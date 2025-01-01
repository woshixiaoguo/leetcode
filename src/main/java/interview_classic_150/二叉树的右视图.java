package interview_classic_150;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ds.TreeNode;

/**
 * 199 二叉树的右视图
 *
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 
 * 示例 1：
 * 
 * 输入：root = [1,2,3,null,5,null,4]
 * 
 * 输出：[1,3,4]
 * 
 * 解释：
 * 
 * <img src="https://assets.leetcode.com/uploads/2024/11/24/tmpd5jn43fs-1.png"/>
 * 
 * 示例 2：
 * 
 * 输入：root = [1,2,3,4,null,null,null,5]
 * 
 * 输出：[1,3,4,5]
 * 
 * 解释：
 * 
 * <img src="https://assets.leetcode.com/uploads/2024/11/24/tmpkpe40xeh-1.png"/>
 * 
 * 示例 3：
 * 
 * 输入：root = [1,null,3]
 * 
 * 输出：[1,3]
 * 
 * 示例 4：
 * 
 * 输入：root = []
 * 
 * 输出：[]
 * 
 * 提示:
 * 
 * 二叉树的节点个数的范围是 [0,100]
 * -100 <= Node.val <= 100
 */

public class 二叉树的右视图 {

    // BFS
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<TreeNode> table = new ArrayList<TreeNode>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        table.add(root);
        while (!table.isEmpty()) {
            int size = table.size();
            ans.add(table.get(size - 1).val);
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = table.remove(0);
                if (treeNode.left != null) {
                    table.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    table.add(treeNode.right);
                }
            }
        }
        return ans;
    }

    @Test
    public void test() {
        Object[] root = { 1, 2, 3, 4, null, null, null, 5 };
        TreeNode node = TreeNode.arrToNode(root);
        List<Integer> ans = rightSideView(node);
        ans.forEach(e -> System.out.println(e));

    }
}

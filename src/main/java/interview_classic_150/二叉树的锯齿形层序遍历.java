package interview_classic_150;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import ds.TreeNode;

/**
 * 103 二叉树的锯齿形层序遍历
 *
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 
 * 示例 1：
 * 
 * <img src="https://assets.leetcode.com/uploads/2021/02/19/tree1.jpg"/>
 * 
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
 *
 * 示例 2：
 * 
 * 输入：root = [1]
 * 输出：[[1]]
 *
 * 示例 3：
 * 
 * 输入：root = []
 * 输出：[]
 * 
 * 提示：
 * 
 * 树中节点数目在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 */

public class 二叉树的锯齿形层序遍历 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
        ArrayList<TreeNode> table = new ArrayList<TreeNode>();
        table.add(root);
        boolean flag = true;
        while (!table.isEmpty()) {
            int size = table.size();
            ArrayList<Integer> row = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {

                TreeNode node = table.remove(0);
                if (flag) {
                    row.add(node.val);

                } else {
                    row.add(0, node.val);
                }
                if (node.left != null)
                    table.add(node.left);
                if (node.right != null)
                    table.add(node.right);
            }
            ans.add(row);
        }
        return ans;
    }

    @Test
    public void test() {
        Object[] root = { 3, 9, 20, null, null, 15, 7 };
        TreeNode node = TreeNode.arrToNode(root);
        List<List<Integer>> ans = zigzagLevelOrder(node);
        for (List<Integer> row : ans) {
            row.forEach(e -> System.out.print(e + " "));
            System.out.println();
        }
    }
}

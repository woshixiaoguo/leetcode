package interview_classic_150;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ds.TreeNode;

/**
 * 637 二叉树的层平均值
 *
 * 给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受。
 * 
 * 示例 1：
 * 
 * <img src="https://assets.leetcode.com/uploads/2021/03/09/avg1-tree.jpg"/>
 * 
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[3.00000,14.50000,11.00000]
 * 解释：第 0 层的平均值为 3,第 1 层的平均值为 14.5,第 2 层的平均值为 11 。
 * 因此返回 [3, 14.5, 11] 。
 * 
 * 示例 2:
 * 
 * <img src="https://assets.leetcode.com/uploads/2021/03/09/avg2-tree.jpg"/>
 * 
 * 输入：root = [3,9,20,15,7]
 * 输出：[3.00000,14.50000,11.00000]
 * 
 * 提示：
 * 
 * 树中节点数量在 [1, 104] 范围内
 * -231 <= Node.val <= 231 - 1
 */

public class 二叉树的层平均值 {

    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Double> ans = new ArrayList<Double>();
        ArrayList<TreeNode> table = new ArrayList<TreeNode>();
        table.add(root);
        while (!table.isEmpty()) {
            int size = table.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = table.remove(0);
                sum += node.val;
                if (node.left != null)
                    table.add(node.left);
                if (node.right != null)
                    table.add(node.right);
            }
            ans.add(sum / size);
        }
        return ans;
    }

    @Test
    public void test() {
        Object[] root = { 3, 9, 20, null, null, 15, 7 };
        TreeNode node = TreeNode.arrToNode(root);
        List<Double> ans = averageOfLevels(node);
        ans.forEach(e -> System.out.println(e));

    }
}

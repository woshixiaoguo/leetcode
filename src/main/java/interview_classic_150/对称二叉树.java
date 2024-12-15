package interview_classic_150;

import java.util.ArrayList;

import org.junit.Test;

import ds.TreeNode;

/**
 * 101 对称二叉树
 *
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *
 * 示例 1：
 *
 * <img src="https://pic.leetcode.cn/1698026966-JDYPDU-image.png"/>
 *
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 
 * 示例 2：
 * 
 * <img src="https://pic.leetcode.cn/1698027008-nPFLbM-image.png"/>
 * 
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 * 
 * 提示：
 * 
 * 树中节点数目在范围 [1, 1000] 内
 * -100 <= Node.val <= 100
 * 
 * 进阶：你可以运用递归和迭代两种方法解决这个问题吗？
 */

public class 对称二叉树 {

    // 递归
    public boolean isSymmetric(TreeNode root) {
        return check2(root.left, root.right);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    // 迭代
    public boolean check2(TreeNode p, TreeNode q) {
        ArrayList<TreeNode> table = new ArrayList<TreeNode>();
        table.add(p);
        table.add(q);
        while (!table.isEmpty()) {
            TreeNode u = table.remove(0);
            TreeNode v = table.remove(0);
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }
            table.add(u.left);
            table.add(v.right);
            table.add(u.right);
            table.add(v.left);
        }
        return true;
    }

    @Test
    public void test() {
        Object[] arr = { 1, 2, 2, null, 3, null, 3 };
        TreeNode root = TreeNode.arrToNode(arr);
        boolean ans = isSymmetric(root);
        System.out.println(ans);

    }
}

package interview_classic_150;

import org.junit.Test;

import ds.TreeNode;

/**
 * 100 相同的树
 *
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * 
 * 示例 1：
 * 
 * <img src="https://assets.leetcode.com/uploads/2020/12/20/ex1.jpg"/>
 * 
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * 
 * 示例 2：
 * 
 * <img src="https://assets.leetcode.com/uploads/2020/12/20/ex2.jpg"/>
 * 
 * 输入：p = [1,2], q = [1,null,2]
 * 输出：false
 * 
 * 示例 3：
 * 
 * <img src="https://assets.leetcode.com/uploads/2020/12/20/ex3.jpg"/>
 * 
 * 输入：p = [1,2,1], q = [1,1,2]
 * 输出：false
 * 
 * 提示：
 * 
 * 两棵树上的节点数目都在范围 [0, 100] 内
 * -104 <= Node.val <= 104
 */

public class 相同的树 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        else if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val)
            return false;
        else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    @Test
    public void test() {
        Object[] p = { 1, 2 };
        // Object[] q = { 1, null, 2 };
        Object[] q = { 1, 2 };
        TreeNode pnode = TreeNode.arrToNode(p);
        TreeNode qnode = TreeNode.arrToNode(q);
        boolean ans = isSameTree(pnode, qnode);
        System.out.println(ans);

    }
}

package sowrd_offer;

import org.junit.Test;

public class 树的子结构 {
    /**
     * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
     *
     * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
     *
     * 例如:
     * 给定的树 A:
     *
     *        3
     *       / \
     *      4   5
     *    / \
     *   1   2
     * 给定的树 B：
     *
     *      4
     *    /
     *   1
     * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
     *
     */

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }

    class Solution {
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if(A == null || B == null) return false;
            return  recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }
        boolean recur(TreeNode A, TreeNode B){
            if(B == null) return true;
            if(A == null || A.val != B.val) return false;
            return recur(A.left, B.left) && recur(A.right, B.right);
        }
    }

    @Test
    public void test(){
        TreeNode A = new TreeNode(3).right = new TreeNode(5);
        TreeNode C = new TreeNode(4);
        A.left = C;
//        C.left = new TreeNode(1);
        C.right = new TreeNode(2);
        TreeNode B = new TreeNode(4).right = new TreeNode(2);
        boolean result = new Solution().isSubStructure(A, B);
        System.out.println(result);
    }
}

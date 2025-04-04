package sowrd_offer;

import org.junit.Test;

public class 对称的二叉树 {
	/**
	 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
	 *
	 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
	 *
	 *     1
	 *    / \
	 *   2   2
	 *  / \ / \
	 * 3  4 4  3
	 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
	 *
	 *     1
	 *    / \
	 *   2   2
	 *    \   \
	 *    3    3
	 *
	 *  
	 *
	 * 示例 1：
	 *
	 * 输入：root = [1,2,2,3,4,4,3]
	 * 输出：true
	 * 示例 2：
	 *
	 * 输入：root = [1,2,2,null,3,null,3]
	 * 输出：false
	 *
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            return check(root, root);
        }
		boolean check(TreeNode a, TreeNode b){
			if(a == null && b == null) return true;
			if(a ==null || b == null) return false;
			return a.val == b.val && check(a.left, b.right) && check(a.right, b.left);
		}
    }

    @Test
    public void test(){
        TreeNode A = new TreeNode(1);
		TreeNode B = new TreeNode(2);
		TreeNode C = new TreeNode(2);
		A.left = B;
		A.right = C;
		B.left = new TreeNode(3);
		B.right = new TreeNode(4);
		C.left = new TreeNode(3);
		C.right = new TreeNode(4);

        boolean result =  new Solution().isSymmetric(A);
		System.out.println(result);
    }
}
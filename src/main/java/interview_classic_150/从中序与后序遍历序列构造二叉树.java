package interview_classic_150;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import ds.TreeNode;

/**
 * 106 从中序与后序遍历序列构造二叉树
 *
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 *
 * 示例 1:
 *
 * <img src="https://assets.leetcode.com/uploads/2021/02/19/tree.jpg"/>
 *
 * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * 输出：[3,9,20,null,null,15,7]
 * 示例 2:
 * 
 * 输入：inorder = [-1], postorder = [-1]
 * 输出：[-1]
 *  
 * 提示:
 * 
 * 1 <= inorder.length <= 3000
 * postorder.length == inorder.length
 * -3000 <= inorder[i], postorder[i] <= 3000
 * inorder 和 postorder 都由 不同 的值组成
 * postorder 中每一个值都在 inorder 中
 * inorder 保证是树的中序遍历
 * postorder 保证是树的后序遍历
 *
 */

public class 从中序与后序遍历序列构造二叉树 {
    int post_idx;
    int[] postorder;
    int[] inorder;
    Map<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

    // 后序遍历的最后一个元素是根节点
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        // 后序遍历最后一个元素
        post_idx = postorder.length-1;

        int idx = 0;
        for(Integer val: inorder){
            idx_map.put(val, idx++);
        }

        return helper(0, inorder.length - 1);
    }

    public TreeNode helper(int in_left, int in_right){
        if(in_left > in_right){
            return null;
        }

        int root_val = postorder[post_idx];
        TreeNode root = new TreeNode(root_val);
        int index = idx_map.get(root_val);
        post_idx--;
        root.right = helper(index+1, in_right);
        root.left = helper(in_left, index-1);
        return root;
    }
    
    @Test
    public void test(){
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode tree = buildTree(inorder, postorder);
        TreeNode.print(tree);

    }
}

package interview_classic_150;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

import ds.TreeNode;

/**
 * 105 从前序与中序遍历序列构造二叉树
 *
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder
 * 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * 
 * 示例 1:
 * 
 * <src="https://assets.leetcode.com/uploads/2021/02/19/tree.jpg"/>
 * 
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 * 示例 2:
 * 
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 * 
 * 
 * 提示:
 * 
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder 和 inorder 均 无重复 元素
 * inorder 均出现在 preorder
 * preorder 保证 为二叉树的前序遍历序列
 * inorder 保证 为二叉树的中序遍历序列
 */

public class 从前序与中序遍历序列构造二叉树 {

    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // int[] 转 List<Integer> boxed:装箱，将基本类型转成包装类
        // List<Integer> pre =
        // Arrays.stream(preorder).boxed().collect(Collectors.toList());

        int n = preorder.length;
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode build(int[] preorder, int[] inorder, int ps, int pe, int is, int ie) {
        if (ps > pe)
            return null;

        int preorder_root = ps;
        int index = indexMap.get(preorder[preorder_root]);

        // 建立根节点
        TreeNode root = new TreeNode(index);
        // 左子树节点数
        int ltree = index - is;

        // (ps,ps+ltree) 先序遍历中 根节点的左子树节点 (is,index-1) 中序遍历中 根节点的左子树节点
        root.left = build(preorder, inorder, ps + 1, ps + ltree, is, index - 1);
        // (ps+ltree+1,pe) 先序遍历中 根节点的右子树节点 (index+1,ie) 中序遍历中 根节点的右子树节点
        root.right = build(preorder, inorder, ps + ltree + 1, pe, index + 1, ie);

        return root;
    }

    @Test
    public void test() {
        int[] preorder = { 3, 9, 20, 15, 7 };
        int[] inorder = { 9, 3, 15, 20, 7 };
        TreeNode tree = buildTree(preorder, inorder);
        TreeNode.print(tree);

    }
}

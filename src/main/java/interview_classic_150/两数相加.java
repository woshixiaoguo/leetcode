package interview_classic_150;

import java.util.Stack;

import org.junit.Test;

import ds.ListNode;

/*
 * 2 两数相加
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序
 * 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例 1：
 *
 * <img width="50px" height="100px" src=
 * "https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2021/01/02/addtwonumber1.jpg"
 * alt="">
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 *
 * 示例 2：
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 *
 * 示例 3：
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 * 提示：
 *
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 */

public class 两数相加 {

    // 会错题意，输入为逆序
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        // 顺序相反
        // int carry = 0;
        // ListNode node = null;
        // while (!stack1.isEmpty() || !stack2.isEmpty()) {
        // int num1 = stack1.isEmpty() ? 0 : stack1.pop();
        // int num2 = stack2.isEmpty() ? 0 : stack2.pop();
        // int sum = num1 + num2 + carry;
        // int bit = (sum % 10);
        // carry = sum / 10;
        // node = new ListNode(bit, node);
        // }
        int carry = 0;
        ListNode node = new ListNode();
        ListNode head = node;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int num1 = stack1.isEmpty() ? 0 : stack1.pop();
            int num2 = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = num1 + num2 + carry;
            int bit = (sum % 10);
            carry = sum / 10;
            node.next = new ListNode(bit);
            node = node.next;
        }
        return head.next;
    }

    public ListNode arrToNode(int[] nums) {
        ListNode node = new ListNode();
        ListNode head = node;
        for (int num : nums) {
            node.next = new ListNode(num);
            node = node.next;
        }
        return head.next;
    }

    // 1ms 100%
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode node = new ListNode();
        ListNode head = node;
        while (l1 != null || l2 != null || carry != 0) {
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;
            int sum = num1 + num2 + carry;
            int bit = sum % 10;
            carry = sum / 10;
            node.next = new ListNode(bit);
            node = node.next;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }
        return head.next;
    }

    @Test
    public void test() {
        // ListNode node13 = new ListNode(3);
        // ListNode node12 = new ListNode(4, node13);
        // ListNode node1 = new ListNode(2, node12);
        //
        // ListNode node23 = new ListNode(4);
        // ListNode node22 = new ListNode(6, node23);
        // ListNode node2 = new ListNode(5, node22);

        // int num1[] = {9, 9, 9, 9, 9, 9, 9};
        // int num2[] = {9, 9, 9, 9};
        //
        int num1[] = { 2, 4, 9 };
        int num2[] = { 5, 6, 4, 9 };

        // int num[] = {3, 4, 2};
        // ListNode res = addTwoNumbers(node1, node2);

        // ListNode node = arrToNode(num);

        ListNode node1 = arrToNode(num1);
        ListNode node2 = arrToNode(num2);
        // ListNode res = node1;

        ListNode res = addTwoNumbers2(node1, node2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}

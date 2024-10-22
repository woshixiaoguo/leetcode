package interview_classic_150;

/*
 * 21 合并两个有序链表
 *
 * 将两个升序链表合并为一个新的 升序
 * 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * <img width="宽度" height="高度"
 * "src=https://assets.leetcode.com/uploads/2020/10/03/merge_ex1.jpg"
 * alt="">
 *
 *
 * 示例 1：
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 *
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *
 *
 * 提示：
 *
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 */

import org.junit.Test;

public class 合并两个有序链表 {

    // 0ms 100.00% 41.48MB 57.85%
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode node = new ListNode();
        ListNode head = node;
        while (list1 != null || list2 != null) {
            int num1 = list1 == null ? 101 : list1.val;
            int num2 = list2 == null ? 101 : list2.val;
            if (num1 <= num2) {
                node.next = new ListNode(num1);
                node = node.next;
                list1 = list1.next;
            } else {
                node.next = new ListNode(num2);
                node = node.next;
                list2 = list2.next;
            }
        }

        return head.next;
    }

    // 迭代 官方
    // 0ms 100.00% 41.34MB 90.17%
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2
        // 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

    // 递归
    // oms 100.00% 41.34MB
    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists3(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists3(l1, l2.next);
            return l2;
        }
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

    @Test
    public void test() {
        int[] l1 = { 1, 2, 4 };
        int[] l2 = { 1, 3, 4 };

        ListNode list1 = arrToNode(l1);
        ListNode list2 = arrToNode(l2);
        ListNode res = mergeTwoLists(list1, list2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
        System.out.println("hello");
    }
}

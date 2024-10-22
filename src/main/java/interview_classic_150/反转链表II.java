package interview_classic_150;

import java.util.Stack;
import org.junit.Test;

/**
 * 92 反转链表II
 * 
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right
 * 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * 
 * 
 * 示例 1：
 * <img height="100px" width="50px" src=
 * "https://assets.leetcode.com/uploads/2021/02/19/rev2ex2.jpg">
 *
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 示例 2：
 * 
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 * 
 * 
 * 提示：
 * 
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 * 
 */
public class 反转链表II {

    // 会错题意
    public ListNode reverseBetween(ListNode head, int left, int right) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode headp = new ListNode(-1, head);
        ListNode leftTail = head;
        ListNode rightHead = null;
        while (headp.next != null) {
            if (headp.next.val == left) {
                leftTail = headp;
                headp = headp.next;
                break;
            }
            headp = headp.next;
        }

        while (headp != null) {
            stack.add(headp);
            if (headp.val == right)
                break;
            headp = headp.next;
        }
        rightHead = headp != null ? headp.next : null;

        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            System.out.println("stack: " + node.val);
            leftTail.next = node;
            leftTail = leftTail.next;
        }
        leftTail.next = rightHead;

        return head;
    }

    // 0ms 100% 40.44MB 6.62%
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode headp = head;
        ListNode leftTail = head, rightHead = null;
        for (int i = 0; headp != null; i++) {
            if (i + 1 >= left) {

                stack.push(headp);
                if (i + 1 == right) {
                    rightHead = headp.next;
                    break;
                }
            } else {
                leftTail = headp;
            }
            headp = headp.next;
        }

        while (!stack.isEmpty()) {
            leftTail.next = stack.pop();
            leftTail = leftTail.next;
        }

        if (left == 1)
            head = head.next;
        leftTail.next = rightHead;
        return head;
    }

    @Test
    public void test() {
        // int[] head_arr = {1, 2, 3, 4, 5};
        int[] head_arr = { 3, 5 };
        ListNode head = ListNode.arrToNode(head_arr);
        // int left = 2, right = 4;
        int left = 1, right = 2;
        ListNode res = reverseBetween2(head, left, right);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}

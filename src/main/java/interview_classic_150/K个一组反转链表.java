package interview_classic_150;

import org.junit.Test;

/**
 * 25 K个一组反转链表
 *
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * 
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 示例1:
 *
 * <img src="https://assets.leetcode.com/uploads/2020/10/03/reverse_ex1.jpg">
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 *
 * 示例2:
 *
 * <img src="https://assets.leetcode.com/uploads/2020/10/03/reverse_ex2.jpg">
 *
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 * 
 * 提示：
 * 链表中的节点数目为 n
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 * 
 * 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？
 * 
 */

public class K个一组反转链表 {

    // 模拟
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode fast = head, slow = head;
        ListNode p = slow;
        ListNode tail = slow;
        int counter = k;
        ListNode start = head;
        ListNode headp;
        ListNode startp;

        // 快指针先走k步
        while (counter != 0) {
            fast = fast.next;
            counter--;
        }
        counter = k;

        // 第一次反转
        while (counter != 0) {
            if (counter == k) {
                p = p.next;
                slow.next = fast;
                counter--;
                continue;
            }
            tail = slow;
            slow = p;
            p = p.next;
            slow.next = tail;
            counter--;
        }
        counter = k;
        headp = slow;

        // 快指针可以继续前进
        while (fast != null) {
            while (counter != 0) {
                fast = fast.next;
                counter--;
                if (fast == null)
                    if (counter == 0) { // 2 1 4 3用例
                        System.out.println("co");
                    } else
                        return headp;
            }
            counter = k;

            slow = p;
            p = p.next;
            startp = slow;

            slow.next = fast;
            counter--;

            while (counter != 0) {
                tail = slow;
                slow = p;
                p = p.next;
                slow.next = tail;
                counter--;
            }
            start.next = slow; // 上一组尾接本组
            start = startp;// 定位本组尾
            counter = k;
        }
        return headp;
    }

    // 递归
    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode currentNode = head;
        int nodeCount = 0;
        // 计算链表长度
        while (currentNode != null) {
            nodeCount++;
            currentNode = currentNode.next;
        }
        // 剩余节点不足k个 直接返回头节点
        if (nodeCount < k) {
            return head;
        }

        ListNode pre = head;
        ListNode cur = head.next;
        for (int i = 0; i < k - 1; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        head.next = reverseKGroup(cur, k);
        return pre;
    }

    // 模拟
    public ListNode reverseKGroup3(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;

        while (head != null) {
            ListNode tail = pre;
            // 查看剩余部分长度是否大于等于 k
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode nex = tail.next;
            ListNode[] reverse = myReverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            // 把子链表重新接回原链表
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }

        return hair.next;

    }

    public ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[] { tail, head };
    }

    // 容易理解版本
    public ListNode reverseKGroup4(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        // 创建虚节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 每一组的前缀节点
        ListNode preGroup = dummy;
        while (true) {
            // 每一组的开始节点
            ListNode start = preGroup.next;
            // 获取每一组的结束节点
            ListNode end = start;
            for (int i = 0; i < k - 1 && end != null; i++) {
                end = end.next;
            }
            // 如果不足k个节点，则停止
            if (end == null)
                break;
            // 记录下一组的开始节点
            ListNode nextStart = end.next;
            // 断裂与下一组的连接
            end.next = null;
            // 反转当前组
            ListNode currGroup = reverse(start);
            // 将当前组与前缀节点连接
            preGroup.next = currGroup;
            // 连接下一组，start已经变为end
            start.next = nextStart;
            // 更新下一组的前缀节点
            preGroup = start;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode pre = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    @Test
    public void test() {
        // int[] head = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int[] head = { 1, 2, 3, 4 };
        ListNode arr = ListNode.arrToNode(head);
        int k = 2;
        ListNode ans = reverseKGroup(arr, k);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}

package interview_classic_150;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;

/**
 * 141 环形链表
 *
 * 给你一个链表的头节点 head，判断链表中是否有环。
 * 
 * 如果链表中有某个节点，可以通过连续跟踪 next
 * 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos
 * 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos
 * 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * 
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 * 
 * 示例 1：
 * 
 * <img src=
 * "https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist.png">
 * 
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 示例 2：
 * 
 * <img src=
 * "https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test2.png">
 * 
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * 示例 3：
 * 
 * <img src=
 * "https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test3.png">
 * 
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 * 
 * 提示：
 * 
 * 链表中节点的数目范围是 [0, 104]
 * -105 <= Node.val <= 105
 * pos 为 -1 或者链表中的一个 有效索引 。
 * 
 * 进阶：你能用 O(1)（即，常量）内存解决此问题吗？
 */

public class 环形链表 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // 哈希表
    // 408ms 5.98% 43.15MB 99.10%
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        List<ListNode> table = new ArrayList<ListNode>();
        table.add(head);
        while (head.next != null) {
            if (table.contains(head.next))
                return true;
            table.add(head.next);
            head = head.next;
        }
        return false;
    }

    // 改进 性能未提升 代码更简洁
    public boolean hasCycle2(ListNode head) {
        List<ListNode> table = new ArrayList<ListNode>();
        while (head != null) {
            if (table.contains(head))
                return true;
            table.add(head);
            head = head.next;
        }
        return false;
    }

    // 官方题解哈希表
    // 4ms 20.02% 43.80MB 6.43%
    public boolean hasCycle3(ListNode head) {
        Set<ListNode> seen = new HashSet<ListNode>();
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    // 快慢指针
    public boolean hasCycle4(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) { // 快慢指针不相遇，则有可能无环
            if (fast == null || fast.next == null) // 快指针走到尾，无环
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        boolean res = hasCycle(head);
        System.out.println(res);
    }
}

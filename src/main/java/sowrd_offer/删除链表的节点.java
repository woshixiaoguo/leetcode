package sowrd_offer;

import org.junit.Test;

public class 删除链表的节点 {
    /**
     * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
     *
     * 返回删除后的链表的头节点。
     *
     * 注意：此题对比原题有改动
     *
     * 示例 1:
     *
     * 输入: head = [4,5,1,9], val = 5
     * 输出: [4,1,9]
     * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     * 示例 2:
     *
     * 输入: head = [4,5,1,9], val = 1
     * 输出: [4,5,9]
     * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
     *  
     *
     * 说明：
     *
     * 题目保证链表中节点的值互不相同
     * 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
     *
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class Solution {
        public ListNode deleteNode(ListNode head, int val) {
            if(head.val == val) return head.next;
            ListNode pre = head, cur = head.next;
            while(cur != null && cur.val != val){
                pre = cur;
                cur = cur.next;
            }
            if(cur != null)pre.next = cur.next;
            return head;
        }
    }

    @Test
    public void test(){

    }
}

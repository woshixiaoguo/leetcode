package sowrd_offer;

import org.junit.Test;

public class 两个链表的第一个公共节点 {
    /**
     * 输入两个链表，找出它们的第一个公共节点。
     *
     * 如下面的两个链表：
     *
     *
     *
     * 在节点 c1 开始相交。
     *
     *  
     *
     * 示例 1：
     *
     *
     *
     * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
     * 输出：Reference of the node with value = 8
     * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
     *  
     *
     * 示例 2：
     *
     *
     *
     * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
     * 输出：Reference of the node with value = 2
     * 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
     *  
     *
     * 示例 3：
     *
     *
     *
     * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
     * 输出：null
     * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
     * 解释：这两个链表不相交，因此返回 null。
     *  
     *
     * 注意：
     *
     * 如果两个链表没有交点，返回 null.
     * 在返回结果后，两个链表仍须保持原有的结构。
     * 可假定整个链表结构中没有循环。
     * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
     * 本题与主站 160 题相同：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
          val = x;
          next = null;
        }
    }

    class Solution {
        /**
         * 双指针解法
         *
         * 首先判断链表为空情况，其中一个为空，则不相交
         *
         * 设链表 A 有 m 个节点，链表 B 有 n 个节点，相交部分有 c 个节点，链表 A 不相交部分有 a 个节点，链表 B 不相交部分有 b 个节点
         * 两个指针分别指向 A B，同时遍历，遍历到链表尾时，将指针指向另一个链表
         *
         * 链表相交时：
         *     a = b 时：
         *       两个指针同时到达第一个相交点
         *     a != b 时：
         *       指针移动 a + b + c 次后，两个指针同时到达第一个相交点
         * 链表不相交时：
         *     m = n 时：
         *       两个指针同时到达两个链表的尾节点
         *     m != n 时：
         *       两个指针移动 m + n 次后，两个指针同时到达彼此链表的尾节点
         * @param headA
         * @param headB
         * @return
         */
        ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if(headA == null || headB == null) return null;
            ListNode Pa = headA, Pb = headB;
            while(Pa != Pb){
                Pa = Pa == null ? headB : Pa.next;
                Pb = Pb == null ? headA : Pb.next;
            }
            return Pa;
        }
    }

    @Test
    public void test(){

    }
}

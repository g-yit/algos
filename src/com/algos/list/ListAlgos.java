package com.algos.list;

/**
 * @author g-yit
 * @description 关于链表的一些算法
 * @createtime 2021/09/29  12:36:00
 */
public class ListAlgos {
    /***
     * 反转链表
     *
     * <p></p>
     * @author g-yit
     * @date 2021/09/29 12:37
     * @param node
     * @return void
     */
    public ListNode reverse(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode pre = null;
        ListNode cur = node;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /***
     * 判断是否list中是否有环
     * 使用快慢指针法，快指针每一次走两步，慢指针每一次走一步
     *<p></p>
     * @author g-yit
     * @date 2021/09/29 14:01
     * @param node
     * @return 是否有环
     */
    public boolean hasCircle(ListNode node) {
        if (node == null || node.next == null) {
            return false;
        }
        ListNode fast = node;
        ListNode slow = node;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            } else {
                return false;
            }
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}

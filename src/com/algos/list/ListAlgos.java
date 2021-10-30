package com.algos.list;

import java.util.ArrayList;

/**
 * @author g-yit
 * @description 关于链表的一些算法
 * @createtime 2021/09/29  12:36:00
 */
public class ListAlgos {
    /**
     * 从尾到头打印链表
     * 使用栈，或者先反转链表，或者递归
     *
     * @param listNode
     * @return java.util.ArrayList<java.lang.Integer>
     * @author g-yit
     * @date 2021/10/10 14:45
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode tmp = listNode;
        while (tmp != null) {
            list.add(0, tmp.val);
            tmp = tmp.next;
        }
        return list;
    }

    ArrayList<Integer> list = new ArrayList();

    /**
     * 递归的进行
     *
     * @param listNode
     * @return java.util.ArrayList<java.lang.Integer>
     * @author g-yit
     * @date 2021/10/10 14:59
     */
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead1(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }

    /***
     * 反转链表
     *
     * <p></p>
     * @author g-yit
     * @date 2021/09/29 12:37
     * @param head
     * @return void
     */
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 合并两个排序链表
     *
     * @param list1
     * @param list2
     * @return com.algos.list.ListNode
     * @author g-yit
     * @date 2021/10/10 15:02
     */
    public ListNode Merge(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                cur.next = list2;
                break;
            } else if (list2 == null) {
                cur.next = list1;
                break;
            } else if (list1.val > list2.val) {
                cur.next = list2;
                list2 = list2.next;
            } else {
                cur.next = list1;
                list1 = list1.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    /**
     * 递归的进行合并两个有序链表
     *
     * @param list1
     * @param list2
     * @return com.algos.list.ListNode
     * @author g-yit
     * @date 2021/10/10 15:12
     */
    public ListNode Merge1(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else {
            if (list1.val < list2.val) {
                list1.next = Merge1(list1.next, list2);
                return list1;
            } else {
                list2.next = Merge1(list1, list2.next);
                return list2;
            }
        }
    }

    /**
     * 找到两个链表的公共节点
     *
     * @param pHead1
     * @param pHead2
     * @return com.algos.list.ListNode
     * @author g-yit
     * @date 2021/10/10 15:14
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
            if (p1 != p2) {
                if (p1 == null) p1 = pHead2;
                if (p2 == null) p2 = pHead1;
            }
        }
        return p1;

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

    /**
     * 链表中 环的入口节点
     * 解题思路：https://leetcode-cn.com/problems/c32eOV/solution/jian-zhi-offer-ii-022-lian-biao-zhong-hu-8f1m/
     *
     * @param pHead
     * @return com.algos.list.ListNode
     * @author g-yit
     * @date 2021/10/10 15:35
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode fast = pHead;
        ListNode slow = pHead;
        while (fast != null) {
            fast = fast.next;
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            slow = slow.next;
            if (slow == fast) {
                fast = pHead;
                break;
            }
        }
        if (fast == pHead) {
            while (fast != null) {
                if (fast == slow) {
                    return slow;
                }
                fast = fast.next;
                slow = slow.next;
            }
        }
        return null;

    }

    /***
     * 得到链表的倒数第k个节点
     * 使用快慢指针 快指针走到k时，慢指针开始走，
     * 1.k刚刚是listnode的长度（返回头部）
     * 2.k<listnode的长度（返回倒数第k个）
     * 3.k>listnode的长度(返回头部)
     * @author g-yit
     * @date 2021/10/09 16:19
     * @param pHead
     * @param k
     * @return com.algos.list.ListNode
     */
    public ListNode getKthFromEnd(ListNode pHead, int k) {
        int fast = 0;//快指针
        ListNode fastNode = pHead;
        ListNode slowNode = pHead;
        while (fastNode != null) {
            fastNode = fastNode.next;
            fast++;
            if (fast > k) {
                slowNode = slowNode.next;
            }
        }
        if (k > fast) {
            return null;
        }
        return slowNode;
    }

    /**
     * 1. 删除链表中的重复节点，重复的直接删除掉
     *
     * @param pHead
     * @return com.algos.list.ListNode
     * @author g-yit
     * @date 2021/10/10 16:28
     */
    public ListNode deleteDuplicates(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode dummy = new ListNode(0, pHead);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }


/*    *//**
     * 删除重复的节点，重复的去重
     *
     * @param pHead
     * @return com.algos.list.ListNode
     * @author g-yit
     * @date 2021/10/10 16:31
     *//*
    public ListNode deleteDuplication2(ListNode pHead) {

    }*/

}

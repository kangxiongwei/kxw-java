package com.kxw.leetcode;

import com.kxw.leetcode.factory.ListNodeFactory;
import com.kxw.leetcode.model.ListNode;

/**
 * 使用查询排序对列表排序
 *
 * @author kangxiongwei
 * @date 2020-04-04 12:11
 */
public class ListNodeInsertSortSolution {

    public static void main(String[] args) {
        ListNodeInsertSortSolution solution = new ListNodeInsertSortSolution();
        ListNode head = ListNodeFactory.buildLinkedList(new int[]{5, 3, 1, 7});
        ListNode node = solution.insertionSortList(head);
        System.out.println(node);
    }

    /**
     * 插入排序
     *
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode ln = new ListNode(0);
        ListNode next = head.next;     //待插入的节点
        ln.next = head;
        head.next = null;
        while (next != null) {
            ListNode prev = ln;
            while (prev.next != null) {
                if (prev.next.val >= next.val) {
                    break;
                }
                prev = prev.next;
            }
            ListNode tail = next.next;
            next.next = prev.next;
            prev.next = next;
            next = tail;
        }
        return ln.next;
    }


}

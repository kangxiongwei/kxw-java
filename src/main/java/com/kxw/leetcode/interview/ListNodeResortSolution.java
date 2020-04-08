package com.kxw.leetcode.interview;

import com.kxw.leetcode.factory.ListNodeFactory;
import com.kxw.leetcode.model.ListNode;
import com.kxw.leetcode.utils.ListNodeUtil;

/**
 * 给定两个有序单向链表，以及一个排序标识，求合并后的排序列表
 *
 * @author kangxiongwei
 * @date 2020-04-08 10:37
 */
public class ListNodeResortSolution {

    public static void main(String[] args) {
        ListNodeResortSolution solution = new ListNodeResortSolution();
        ListNode head1 = ListNodeFactory.buildLinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode head2 = ListNodeFactory.buildLinkedList(new int[]{8, 7, 6, 5});
        ListNode listNode = solution.mergeTwoSortedList(head1, head2, false);
        System.out.println(listNode);
    }

    /**
     * 合并两个有序列表
     *
     * @param head1 列表1
     * @param head2 列表2
     * @param sort  true 升序 false 降序
     * @return
     */
    public ListNode mergeTwoSortedList(ListNode head1, ListNode head2, boolean sort) {
        boolean sort1 = ListNodeUtil.sort(head1);
        boolean sort2 = ListNodeUtil.sort(head2);
        if (sort1 == sort2 && sort1 == sort) {
            return mergeSortedList(head1, head2, sort);
        }
        if (sort1 == sort2) {
            ListNode reverse1 = ListNodeUtil.reverse(head1);
            ListNode reverse2 = ListNodeUtil.reverse(head2);
            return mergeSortedList(reverse1, reverse2, sort);
        }
        if (sort1 == sort) {
            ListNode reverse = ListNodeUtil.reverse(head2);
            return mergeSortedList(head1, reverse, sort);
        }
        if (sort2 == sort) {
            ListNode reverse = ListNodeUtil.reverse(head1);
            return mergeSortedList(reverse, head2, sort);
        }
        return null;
    }

    /**
     * 合并两个顺序一致的链表
     *
     * @param head1
     * @param head2
     * @return
     */
    public ListNode mergeSortedList(ListNode head1, ListNode head2, boolean sort) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode ln = new ListNode(0);
        ListNode h1 = head1;
        ListNode h2 = head2;
        ListNode node = ln;
        while (h1 != null && h2 != null) {
            int val1 = h1.val;
            int val2 = h2.val;
            if (sort) {
                if (val1 <= val2) {
                    h1 = add(node, h1);
                } else {
                    h2 = add(node, h2);
                }
            } else {
                if (val1 <= val2) {
                    h2 = add(node, h2);
                } else {
                    h1 = add(node, h1);
                }
            }
            node = node.next;
        }
        if (h1 != null) {
            node.next = h1;
        }
        if (h2 != null) {
            node.next = h2;
        }
        return ln.next;
    }

    private ListNode add(ListNode node, ListNode h) {
        ListNode next1 = h.next;
        h.next = null;
        node.next = h;
        return next1;
    }



}

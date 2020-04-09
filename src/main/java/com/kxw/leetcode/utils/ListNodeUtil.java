package com.kxw.leetcode.utils;

import com.kxw.leetcode.model.ListNode;

/**
 * 给单链表提供一组工具方法
 *
 * @author kangxiongwei
 * @date 2020-04-04 13:18
 */
public class ListNodeUtil {

    /**
     * 翻转一个单链表
     *
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode ln = new ListNode(0);
        //利用头插法，将原列表添加到新列表中
        ListNode node = head;
        while (node != null) {
            ListNode nextNode = node.next;
            ListNode next = ln.next;
            ln.next = node;
            node.next = next;
            node = nextNode;
        }
        return ln.next;
    }

    /**
     * 获取有序列表是升序还是降序
     *
     * @param head
     * @return
     */
    public static boolean sort(ListNode head) {
        if (head == null || head.next == null) {
            //没有元素或只有一个元素，则顺序为默认顺序
            return true;
        }
        boolean sort = true;
        ListNode node = head;
        while (node.next != null) {
            int val1 = node.val;
            int val2 = node.next.val;
            if (val1 < val2) {
                break;
            } else if (val1 == val2) {
                node = node.next;
            } else {
                sort = false;
                break;
            }
        }
        return sort;
    }

    public static String printListNode(ListNode head) {
        StringBuilder builder = new StringBuilder();
        ListNode h = head;
        while (h != null) {
            builder.append("-->").append(h.val);
            h = h.next;
        }
        return builder.toString().substring("-->".length());
    }



}

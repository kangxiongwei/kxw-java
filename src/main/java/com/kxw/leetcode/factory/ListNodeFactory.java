package com.kxw.leetcode.factory;

import com.kxw.leetcode.model.ListNode;

/**
 * 构建列表的工厂
 *
 * @author kangxiongwei
 * @date 2020-04-04 13:03
 */
public class ListNodeFactory {

    /**
     * 根据值创建一个单列表
     *
     * @param values
     * @return
     */
    public static ListNode buildLinkedList(int[] values) {
        if (values == null) {
            return null;
        }
        ListNode head = new ListNode(0);
        ListNode node = head;
        for (int val: values) {
            node.next = new ListNode(val);
            node = node.next;
        }
        return head.next;
    }


}

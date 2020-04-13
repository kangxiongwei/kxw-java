package com.kxw.leetcode;

import com.kxw.leetcode.model.RandomListNode;

/**
 * 现在有一个这样的链表：链表的每一个节点都附加了一个随机指针，随机指针可能指向链表中的任意一个节点或者指向空。
 * 请对这个链表进行深拷贝。
 *
 * @author kangxiongwei
 * @date 2020-04-09 20:16
 */
public class RandomListNodeCopySolution {

    public static void main(String[] args) {
        RandomListNodeCopySolution solution = new RandomListNodeCopySolution();
        RandomListNode node1 = new RandomListNode(-1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        node1.next = node2;
        node2.next = node3;
//        node1.random = node3;
//        node2.random = node1;
//        node3.random = node2;

        RandomListNode listNode = solution.copyRandomList(node1);
        while (listNode != null) {
            System.out.println(listNode.label + "," + (listNode.random == null ? "" : listNode.random.label));
            listNode = listNode.next;
        }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }
        RandomListNode node = head;
        while (node != null) {
            RandomListNode copyNode = new RandomListNode(node.label);
            RandomListNode next = node.next;
            node.next = copyNode;
            copyNode.next = next;
            node = next;
        }
        RandomListNode newHead = new RandomListNode(0);
        RandomListNode newNode = newHead;
        node = head;
        while (node != null && node.next != null) {
            RandomListNode next = node.next;
            next.random = node.random == null ? null : node.random.next;
            newNode.next = next;
            newNode = newNode.next;
            node = node.next.next;
        }
        return newHead.next;
    }

}

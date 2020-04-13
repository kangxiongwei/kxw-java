package com.kxw.leetcode;

import com.kxw.leetcode.model.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 现在有一个这样的链表：链表的每一个节点都附加了一个随机指针，随机指针可能指向链表中的任意一个节点或者指向空。
 * 请对这个链表进行深拷贝。
 *
 * @author kangxiongwei
 * @date 2020-04-09 20:16
 */
public class RandomListNodeCopySolution {

    public static void main(String[] args) {

    }

    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode node = head;
        RandomListNode copyNode = new RandomListNode(0);
        //记录每个节点的位置
        Map<RandomListNode, Integer> map = new HashMap<>();
        int i = 0;
        while (node != null) {
            map.put(node, i);
            i++;
            node = node.next;
        }
        //拷贝列表
        node = head;
        RandomListNode rn = copyNode;
        int index = 0;
        while (node != null) {
            RandomListNode rln = new RandomListNode(node.label);
            RandomListNode random = node.random;
            node = node.next;
            rn.next = rln;
            rn = rln;
        }




        return null;
    }

}

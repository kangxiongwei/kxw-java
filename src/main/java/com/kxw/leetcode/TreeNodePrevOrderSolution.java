package com.kxw.leetcode;

import com.kxw.leetcode.model.TreeNode;

import java.util.ArrayList;

/**
 * 先序遍历二叉树
 *
 * @author kangxiongwei
 * @date 2020-04-04 17:28
 */
public class TreeNodePrevOrderSolution {


    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        list.add(root.val);
        if (root.left != null) {
            list.addAll(preorderTraversal(root.left));
        }
        if (root.right != null) {
            list.addAll(preorderTraversal(root.right));
        }
        return list;
    }


}

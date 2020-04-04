package com.kxw.leetcode;

import com.kxw.leetcode.factory.TreeNodeFactory;
import com.kxw.leetcode.model.TreeNode;

import java.util.ArrayList;

/**
 * 后序遍历树节点
 *
 * @author kangxiongwei
 * @date 2020-04-04 17:10
 */
public class TreeNodePostOrderSolution {

    public static void main(String[] args) {
        TreeNodePostOrderSolution solution = new TreeNodePostOrderSolution();
        TreeNode root = TreeNodeFactory.buildTree();
        ArrayList<Integer> list = solution.postOrderTraversal(root);
        System.out.println(list);
    }


    public ArrayList<Integer> postOrderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        if (root.left != null) {
            list.addAll(postOrderTraversal(root.left));
        }
        if (root.right != null) {
            list.addAll(postOrderTraversal(root.right));
        }
        list.add(root.val);
        return list;
    }


}

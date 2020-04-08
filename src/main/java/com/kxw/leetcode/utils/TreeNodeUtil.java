package com.kxw.leetcode.utils;

import com.kxw.leetcode.model.TreeNode;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 树节点操作的工具类
 *
 * @author kangxiongwei
 * @date 2020-04-08 20:40
 */
public class TreeNodeUtil {

    /**
     * 前序遍历树
     *
     * @param root
     * @return
     */
    public static String preOrderTreeNode(TreeNode root) {
        StringBuilder tree = new StringBuilder();
        tree.append(root.val);
        if (root.left != null) {
            String leftTree = preOrderTreeNode(root.left);
            tree.append(leftTree);
        }
        if (root.right != null) {
            String rightTree = preOrderTreeNode(root.right);
            tree.append(rightTree);
        }
        return tree.toString();
    }

    /**
     * 广度优先遍历
     *
     * @param root
     * @return
     */
    public static String breadthFirst(TreeNode root) {
        List<TreeNode> parent = new ArrayList<>();
        parent.add(root);
        return breadthFirst(parent);
    }

    /**
     * 遍历每一层的结果
     *
     * @param parents
     * @return
     */
    public static String breadthFirst(List<TreeNode> parents) {
        if (parents.isEmpty()) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        List<TreeNode> children = new ArrayList<>();
        for (TreeNode parent: parents) {
            builder.append(parent.val);
            if (parent.left != null) {
                children.add(parent.left);
            }
            if (parent.right != null) {
                children.add(parent.right);
            }
        }
        String first = breadthFirst(children);
        return builder.toString() + first;
    }

}

package com.kxw.leetcode;

import com.kxw.leetcode.model.TreeNode;

/**
 * 判断两棵树是否相等
 *
 * @author kangxiongwei
 * @date 2020-04-04 17:33
 */
public class TreeNodeSameTreeSolution {


    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        //都不为空
        if (p.val != q.val) {
            return false;
        }
        //比较左子树
        boolean left = isSameTree(p.left, q.left);
        if (!left) {
            return false;
        }
        return isSameTree(p.right, q.right);
    }

}

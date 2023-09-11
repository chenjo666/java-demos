////package com.cj;
////
////import java.util.*;
////
/////*
//// * public class TreeNode {
//// *   int val = 0;
//// *   TreeNode left = null;
//// *   TreeNode right = null;
//// *   public TreeNode(int val) {
//// *     this.val = val;
//// *   }
//// * }
//// */
////
//public class Solution {
//    /**
//     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
//     *
//     * 返回节点权值1个数比0的个数多一的路径数
//     * @param root TreeNode类 权值为0和1的二叉树根节点
//     * @return int整型
//     */
//    int ans = 0;
//    public int pathNumber (TreeNode root) {
//        // write code here
//        dfs(root, 0, 0);
//        return ans;
//    }
//    public void dfs(TreeNode node, int cnt0, int cnt1) {
//        if (node.val == 0) {
//            cnt0++;
//        } else {
//            cnt1++;
//        }
//        if (node.left == null && node.right == null) {
//            if (cnt1 == cnt0 + 1) {
//                ans++;
//            }
//            return;
//        }
//        if (node.left != null) {
//            dfs(node.left, cnt0, cnt1);
//        }
//        if (node.right != null) {
//            dfs(node.right, cnt0, cnt1);
//        }
//    }
//}

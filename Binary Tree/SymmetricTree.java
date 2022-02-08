//https://leetcode.com/problems/symmetric-tree/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return (root==null) || check(root.left,root.right);
    }
    boolean check(TreeNode left,TreeNode right){
        if(left==null || right==null) return left==right;
        if(left.val!=right.val) return false;
        return check(left.left,right.right) && check(left.right,right.left);
    }
}
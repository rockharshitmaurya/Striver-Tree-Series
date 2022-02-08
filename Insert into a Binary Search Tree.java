//https://leetcode.com/problems/insert-into-a-binary-search-tree/
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode node = root, get = new TreeNode(-1);
        while (root != null) {
            if (root.val > val) {
            get = root;
            root = root.left;
            } else {
            if (root.right == null) {
            root.right = new TreeNode(val);
            return node;
            }
            root = root.right;
            }
        }
        TreeNode add = new TreeNode(val);
        add.left = get.left;
        get.left = add;
        return node;  
    }
}
// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
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
    public void flatten(TreeNode root) {
        TreeNode node=root;
        while(node!=null){
               if(node.left!=null){
              TreeNode prev=node.left;
               while(prev.right!=null){
                   prev=prev.right;
               }
                prev.right=node.right;
                node.right=node.left;
                node.left=null;
            }
            node=node.right;
           
            
        }
    }
}
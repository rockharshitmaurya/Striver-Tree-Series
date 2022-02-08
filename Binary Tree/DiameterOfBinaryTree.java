//https://leetcode.com/problems/diameter-of-binary-tree/
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
    public int diameterOfBinaryTree(TreeNode root) {
        int mem[]=new int[1];
        int k=check(root,mem);
        return mem[0];
    }
    
    int check(TreeNode root,int[] mem){
        if(root==null) return 0;
        
        int lh=check(root.left,mem);
        int rh=check(root.right,mem);
        mem[0]=Math.max(mem[0],(lh+rh));
        return Math.max(lh,rh)+1;
    }
}
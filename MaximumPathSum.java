//https://leetcode.com/problems/binary-tree-maximum-path-sum/
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
    public int maxPathSum(TreeNode root) {
      int arr[]=new int[1];
        arr[0]=Integer.MIN_VALUE;
        check(root,arr);
        return arr[0];
    }
    int check(TreeNode root,int[] arr){
        if(root==null)  return 0;
        
        int lh=Math.max(0,check(root.left,arr));
        int rh=Math.max(0,check(root.right,arr));
        
        arr[0]=Math.max(arr[0],lh+rh+root.val);
        return root.val+Math.max(lh,rh);
    }
}
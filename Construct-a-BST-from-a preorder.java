// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
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
    public TreeNode bstFromPreorder(int[] pre) {
        return BST(pre,Integer.MAX_VALUE,new int[]{0});
    }
    TreeNode BST(int pre[],int max,int idx[]){
        if(pre.length==idx[0] || pre[idx[0]]>max) return null;
        TreeNode node=new TreeNode(pre[idx[0]++]);
        node.left= BST(pre,node.val,idx);
        node.right=BST(pre,max,idx);
        return node;
    }
}
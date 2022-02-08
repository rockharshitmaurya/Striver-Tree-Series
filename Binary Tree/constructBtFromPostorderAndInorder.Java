//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
      if(inorder.length!=postorder.length) return null;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0; i<inorder.length; i++) map.put(inorder[i],i);
        return makeTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1,map);
    }
    
    TreeNode makeTree(int in[],int instart,int inend,int post[],int poststart,int postend,HashMap<Integer,Integer> map){
        if(instart>inend || poststart>postend) return null;
        
        TreeNode root=new TreeNode(post[postend]);
        int idx=map.get(root.val);
        int numsleft=idx-instart;
        root.left=makeTree(in,instart,idx-1,post,poststart,poststart+numsleft-1,map);
        root.right=makeTree(in,idx+1,inend,post,poststart+numsleft,postend-1,map);
        return root;
    }
}
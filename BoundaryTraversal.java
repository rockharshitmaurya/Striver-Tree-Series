//https://www.codingninjas.com/codestudio/problems/boundary-traversal_790725
/************************************************************

    Following is the Binary Tree node structure:
    
   class TreeNode {
	    int data;
	    TreeNode left;
	    TreeNode right;

	    TreeNode(int data) {
		    this.data = data;
		    this.left = null;
		    this.right = null;
	    }

    }

************************************************************/

import java.util.ArrayList;

public class Solution {
static	Boolean isLeaf(TreeNode root){
        return (root.left==null) && (root.right==null);
    }
    static void addLeft(TreeNode root,ArrayList<Integer> res){
        TreeNode node=root.left;
           while(node!=null){
               if(!isLeaf(node)) res.add(node.data);
               if(node.left!=null) node=node.left;
               else node=node.right;
           }
    }
    static void addRight(TreeNode root,ArrayList<Integer> res){
        TreeNode node=root.right;
        ArrayList<Integer> list=new ArrayList<>();
        while(node!=null){
            if(!isLeaf(node)) list.add(node.data);
            if(node.right!=null) node=node.right;
            else node=node.left;
        }
        int i=0;
        for(i=list.size()-1; i>=0; i--){
            res.add(list.get(i));
        }
    }
    static void addLeaves(TreeNode root,ArrayList<Integer> res){
		if(isLeaf(root)){
            res.add(root.data);
            return;
        }
        if (root.left != null) addLeaves(root.left, res);
        if (root.right != null) addLeaves(root.right, res);
    }
    public static   ArrayList<Integer> traverseBoundary(TreeNode root){
		ArrayList<Integer> ans=new ArrayList<Integer>();
        if(!isLeaf(root)) ans.add(root.data);
        addLeft(root,ans);
        addLeaves(root,ans);
        addRight(root,ans);
        return ans;
	}
}

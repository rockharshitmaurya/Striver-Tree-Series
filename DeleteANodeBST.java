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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        TreeNode node=root;
        if(root.val==key){
            return helper(root);
        }
        while(node!=null){
            TreeNode pre=node;
            if(node.val>key){
                if(node.left!=null && node.left.val==key){
                  node.left=helper(node.left);
                    break;
                }else node=node.left;
            }else{
                if(node.right!=null && node.right.val==key){
                  node.right=helper(node.right);
                    break;
                }else node=node.right;
            }
        }
        return root;
    }

 TreeNode helper(TreeNode root){
        if(root.right==null){
            return root.left;
        }else if(root.left==null){
            return root.right;
        }else{
             TreeNode new_node=root.right;
                while(new_node.left!=null){
                    new_node=new_node.left;
                }
                new_node.left=root.left;
                   return root.right;
        }
    }
}
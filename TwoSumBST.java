// https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
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
public class  BSTIterator{
    Stack<TreeNode> st=new Stack<>();
       boolean reverse=true;
       public BSTIterator(TreeNode root,boolean isReverse) {
           reverse=isReverse;
           pushAll(root);
       }
       private  void pushAll(TreeNode root){
            while(root!=null){
                st.push(root);
                if(reverse==true){
                root=root.right;   
                }else{
                    root=root.left;
                }
            }
       }
       public int next(){
           TreeNode node=st.pop();
           if(reverse==true) pushAll(node.left);
           else pushAll(node.right);
           return node.val;
       }
       private boolean hasNext(TreeNode root){
           return !st.isEmpty();
       }
   }
class Solution {
  
   
   public boolean findTarget(TreeNode root, int k) {
       BSTIterator l=new BSTIterator(root,false);
       BSTIterator r=new BSTIterator(root,true);
      int i=l.next();
       int j=r.next();
       while(i<j){
           if((i+j)==k) return true;
           else if((i+j)<k) i=l.next();
           else j=r.next();
       }
       return false;
   }
}
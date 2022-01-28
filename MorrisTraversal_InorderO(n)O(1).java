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
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<>();
        TreeNode cur=root;
        while(cur!=null){
        if(cur.left==null){
            list.add(cur.val);
            cur=cur.right;
        }else{
            TreeNode prev=cur.left;
            while(prev.right!=null && prev.right!=cur){
                    prev=prev.right;
            }
            if(prev.right==null){
                prev.right=cur;
                cur=cur.left;
            }else{
                prev.right=null;
                list.add(cur.val);
                cur=cur.right;
            }
        }
        }
        return list;
    }
}
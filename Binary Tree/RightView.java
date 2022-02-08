//https://leetcode.com/problems/binary-tree-right-side-view/
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        check(root,res,0);
        return res;
    }
    void check(TreeNode node,List<Integer> res,int level){
        if(node==null) return;
        if(res.size()==level){
            res.add(node.val);
        }
        check(node.right,res,level+1);
        check(node.left,res,level+1);
    }
}
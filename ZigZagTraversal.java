//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(root==null) return res;
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.offer(root);
        boolean flag=true;
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> list=new ArrayList<Integer>();
            for(int i=0; i<size; i++){
                if(q.peek().left!=null) q.offer(q.peek().left);
                if(q.peek().right!=null) q.offer(q.peek().right);
                if(flag==true) list.add(q.poll().val);
                else list.add(0,q.poll().val);
            }
            flag=!flag;
            res.add(list);
        }
        return res;
    }
}
// https://leetcode.com/problems/maximum-width-of-binary-tree/
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
class Pair{
    TreeNode node;
    int data;
    Pair(TreeNode _node,int _data){
        node=_node;
        data=_data;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q=new LinkedList<Pair>();
        q.offer(new Pair(root,1));
        int res=0;
        while(!q.isEmpty()){
            int first=0,last=0,mmin=q.peek().data;
            int size=q.size(); 
            for(int i=0; i<size; i++){
                Pair pop=q.poll();
                TreeNode node=pop.node;
                int cur_id=pop.data-mmin;
                if(i==0) first=cur_id;
                if(i==size-1) last=cur_id;
                if(node.left!=null) q.offer(new Pair(node.left,(2*cur_id)));
                if(node.right!=null) q.offer(new Pair(node.right,(2*cur_id+1)));

            }
            res=Math.max(res,last-first+1);
        }
        return res;
    }
}

// Recusrive Solution
// int max = 0;
// public int widthOfBinaryTree(TreeNode root) {
//     helper(root, new ArrayList<Integer>(), 0, 0);
//     return max;
// }

// void helper(TreeNode root, List<Integer> lefts, int level, int index){
//     if(root == null) return;
//     if(level == lefts.size()){
//        lefts.add(index); 
//     }
//     max = Math.max(max, index - lefts.get(level) + 1);
//     helper(root.left, lefts, level + 1, index * 2);
//     helper(root.right, lefts, level + 1, index * 2 + 1);
// }
// https://leetcode.com/problems/binary-tree-postorder-traversal/
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
    int num;
    TreeNode node;
    Pair(TreeNode _node,int _num){
        num=_num;
        node=_node;
    }
}
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<Pair> st=new Stack<Pair>();
        List<Integer> pre=new ArrayList<>();
        List<Integer> in=new ArrayList<>();
        List<Integer> post=new ArrayList<>();
        if(root==null) return post;
        st.push(new Pair(root,1));
        while(!st.isEmpty()){
            Pair cur=st.pop();
            //pre
            if(cur.num==1){
               pre.add(cur.node.val);
                cur.num++;
                st.push(cur);
                if(cur.node.left!=null){
                    st.push(new Pair(cur.node.left,1));
                }
            }
            //in
            else if(cur.num==2){
                in.add(cur.node.val);
                cur.num++;
                st.push(cur);
                if(cur.node.right!=null){
                    st.push(new Pair(cur.node.right,1));
                }
            }else{
                //post
                post.add(cur.node.val);
            }
            
            
            
            
          
        }
        return post;
    }
}

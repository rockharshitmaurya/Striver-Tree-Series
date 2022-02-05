// https://leetcode.com/problems/binary-search-tree-iterator/
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
class BSTIterator {
    Stack<TreeNode> st=new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        pushAll(root);
    }
    
    public int next() {
      TreeNode pop_node=st.pop();
      pushAll(pop_node.right);
        return pop_node.val;
    }
    
    public boolean hasNext() {
      return (!st.isEmpty()==true);  
    }
    private void pushAll(TreeNode root){
        for(; root!=null; st.push(root),root=root.left);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
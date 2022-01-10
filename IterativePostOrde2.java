// https://leetcode.com/problems/binary-tree-postorder-traversal/
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
     List<Integer> res=new ArrayList<Integer>();
        Stack<TreeNode> st=new Stack<TreeNode>();
        TreeNode cur=root;
        if(cur==null) return res;
        while(cur!=null || !st.isEmpty()){
            if(cur!=null){
                st.push(cur);
                cur=cur.left;
            }else{
                TreeNode temp=st.peek().right;
                if(temp==null){
                    temp=st.pop();
                    res.add(temp.val);
                    while(!st.isEmpty() && temp==st.peek().right){
                        temp=st.pop();
                        res.add(temp.val);    
                    }
                }else{
                    cur=temp;
                }
                
            }
            
        }
        return res;
    }
}
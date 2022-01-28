//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
     if(root==null) return "";
        StringBuilder str=new StringBuilder();
    Queue<TreeNode> q=new LinkedList<>();
    q.offer(root);
    while(!q.isEmpty()){
        TreeNode add=q.poll();
        if(add==null){
            str.append("# ");
            continue;
        }
        str.append(add.val+" ");
        q.offer(add.left);
        q.offer(add.right);
    }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        String arr[]=data.split(" ");
        Queue<TreeNode> q=new LinkedList<>();
        TreeNode root=new TreeNode(Integer.parseInt(arr[0]));
        q.offer(root);
        for(int i=1; i<arr.length; i++){
           TreeNode parent=q.poll();
            if(!arr[i].equals("#")){
              TreeNode left=new TreeNode(Integer.parseInt(arr[i]));
                parent.left=left;
                q.offer(left);
           } 
             if(!arr[++i].equals("#")){
              TreeNode right=new TreeNode(Integer.parseInt(arr[i]));
                parent.right=right;
                q.offer(right);
           } 
        }
    return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
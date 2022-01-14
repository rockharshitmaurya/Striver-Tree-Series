/*********************************************

    class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

*********************************************/
import java.util.*;
class Pair{
    int x;
    BinaryTreeNode node;
    public Pair(BinaryTreeNode _node,int _x){
        node=_node;
        x=_x;
    }
}

public class Solution {
    public static ArrayList<Integer> bottomView(BinaryTreeNode root) {
        ArrayList<Integer>  res=new ArrayList<>();
        if(root==null) return res;
        Map<Integer,Integer> map=new TreeMap<>();
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
           Pair p=q.poll();
            BinaryTreeNode node=p.node;
            int x=p.x;
            map.put(x,node.val);
            if(node.left!=null) q.offer(new Pair(node.left,x-1));
            if(node.right!=null) q.offer(new Pair(node.right,x+1));
        }
        for(int val:map.values()){
            res.add(val);
        }
        return res;
    }
}

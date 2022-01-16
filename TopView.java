/************************************************************

    Following is the TreeNode class structure:

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

************************************************************/
import java.util.*;
class Pair{
    int level;
    BinaryTreeNode node;
    public Pair(BinaryTreeNode _node,int _level){
        level=_level;
        node=_node;
    }
}
public class Solution {
	public static ArrayList<Integer> getTopView(BinaryTreeNode root) {
		ArrayList<Integer> res=new ArrayList<Integer>();
            if(root==null) return res;
        Queue<Pair> q=new LinkedList<>();
        Map<Integer,Integer> map=new TreeMap<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            Pair p=q.poll();
            BinaryTreeNode node=p.node;
            int level=p.level;
            if(!map.containsKey(level)){
                map.put(level,node.val);
            }
            if(node.left!=null) q.offer(new Pair(node.left,level-1));
            if(node.right!=null) q.offer(new Pair(node.right,level+1));
        }
        for(int nd:map.values()){
            res.add(nd);
        }
        return res;
	}
}
//https://www.codingninjas.com/codestudio/problems/time-to-burn-tree_630563
import java.util.*;
/**********************************************************	
	
	Following is the representation of Binary Tree Node:
 	
 	class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;
		
		public BinaryTreeNode(T data) {
			this.data = data;
		}
	}

*********************************************************/

public class Solution
{
    static BinaryTreeNode makeParent(BinaryTreeNode<Integer> root,HashMap<BinaryTreeNode<Integer>,BinaryTreeNode<Integer>> parents,int start){
        Queue<BinaryTreeNode> q=new LinkedList<>();
        q.offer(root);
        BinaryTreeNode<Integer> res = new BinaryTreeNode<Integer>(-1);
        while(!q.isEmpty()){
              BinaryTreeNode<Integer> node=q.poll();
               if(node.data==start){
                res=node;   
               }
              if(node.left!=null){
                  q.offer(node.left);
                  parents.put(node.left,node);
              }
              if(node.right!=null){
                  q.offer(node.right);
                  parents.put(node.right,node);
              }
        }
        return res;
    }
public static int timeToBurnTree(BinaryTreeNode<Integer> root, int start)
    {
        HashMap<BinaryTreeNode<Integer>,BinaryTreeNode<Integer>> parents=new HashMap<>();
    	BinaryTreeNode<Integer> target=makeParent(root,parents,start);
    
    	Queue<BinaryTreeNode<Integer>> q=new LinkedList<>();
    	HashMap<BinaryTreeNode,Boolean> visited=new HashMap<>();
    	q.offer(target);
    	visited.put(target,true);
    	int cur=0;
    	while(!q.isEmpty()){
         Boolean flag=false;
         int size=q.size();
            for(int i=0; i<size; i++){
              BinaryTreeNode node=q.poll();
              if(node.left!=null && visited.get(node.left)==null){
                  q.offer(node.left);
                  visited.put(node.left,true);
                  flag=true;
              }
              if(node.right!=null && visited.get(node.right)==null){
                  q.offer(node.right);
                  visited.put(node.right,true);
                  flag=true;
              }
              if(parents.get(node)!=null && visited.get(parents.get(node))==null){
                q.offer(parents.get(node));
                visited.put(parents.get(node),true);
                  flag=true;
              }
            }
            if(flag==true) cur++;
        }
    return cur;
    	
    }
}
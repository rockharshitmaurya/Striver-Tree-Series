//https://www.interviewbit.com/problems/path-to-given-node/
/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> arr=new ArrayList<>();
        if(A==null) return arr;
        getPath(A,arr,B);
        return arr;
    }
    boolean getPath(TreeNode root,ArrayList<Integer> arr,int B){
        if(root==null) return false;
        arr.add(root.val);
        if(root.val==B) return true;
        if(getPath(root.left, arr,B) || getPath(root.right,arr,B)) return true; 
        arr.remove(arr.size()-1);
        return false;
    }

}
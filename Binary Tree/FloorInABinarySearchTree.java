// https://www.codingninjas.com/codestudio/problems/floor-from-bst_920457
/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T>
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/

public class Solution {

    public static int floorInBST(TreeNode<Integer> root, int x) {
       int fl=-1;
        while(root!=null){
			if(root.data==x){
                fl=root.data;
                return fl;
            }
            if(x>root.data){
                fl=root.data;
                root=root.right;
            }else{
                root=root.left;
            }
        }
        return fl;
    }
}
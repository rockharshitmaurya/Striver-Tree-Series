// https://www.codingninjas.com/codestudio/problems/ceil-from-bst_920464
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

    public  static int findCeil(TreeNode<Integer> root, int key) {

        int ceil = -1; 
        while (root != null) {
            if (root.data == key) {
                ceil = root.data;
                return ceil;
            }

            if (key > root.data) {
                root = root.right;
            }
            else {
                ceil = root.data; 
                root = root.left;
            }
        }
        return ceil;

    }
}


import java.util.*;
class Node{
    int data;
    Node left;
    Node right;
    public Node(int key){
        this.data=key;
    }
}
class IterativePreorder{
    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.left.right.left=new Node(8);
        root.right=new Node(3);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        root.right.right.left=new Node(9);
        root.right.right.right=new Node(10);
        System.out.println(preorder(root));
    }
    public static List<Integer> preorder(Node root){
        List<Integer> list=new LinkedList<>();
        Stack<Node> stack=new Stack<Node>();
        if(root==null){
            return list;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            root=stack.pop();
            list.add(root.data);
                if(root.right!=null) stack.push(root.right);
                if(root.left!=null) stack.push(root.left);
        }
            return list;

    }
}
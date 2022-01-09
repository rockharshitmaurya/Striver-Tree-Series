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
        System.out.println(inorderTraversal(root));
    }
    public static List<Integer> inorderTraversal(Node root) {
        Stack<Node> st=new Stack<>();
        List<Integer> list=new ArrayList<>();
        Node node=root;
        while(true){
            if(node!=null){
                st.push(node);
                node=node.left;
            }else{
                if(st.isEmpty()){
                    break;
                }
                node=st.pop();
                list.add(node.data);
                node=node.right;
                
            }
        }
        return list;
    }
}
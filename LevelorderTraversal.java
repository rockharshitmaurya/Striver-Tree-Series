import java.util.*;
class Node{
    int data;
    Node left;
    Node right;
    public Node(int key){
        this.data=key;
    }
}
class LevelorderTraversal{
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
        System.out.println(levelorder(root));
    }
    public static List<List<Integer>> levelorder(Node root){
        List<List<Integer>> list=new LinkedList<List<Integer>>();
        Queue<Node> q=new LinkedList<Node>();
        if(root==null){
            return list;
        }
        q.offer(root);
        while(!q.isEmpty()){
            int n=q.size();
            List<Integer> toadd=new ArrayList<>();
            for(int i=0; i<n; i++){
                if(q.peek().left!=null) q.offer(q.peek().left);
                if(q.peek().right!=null) q.offer(q.peek().right);
                toadd.add(q.poll().data);
                
            }
            list.add(toadd);
        }
            return list;

    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private void makeParents(TreeNode root,Map<TreeNode,TreeNode> map){
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0; i<size; i++){
                TreeNode cur=q.poll();
                if(cur.left!=null){
                    q.offer(cur.left);
                    map.put(cur.left,cur);
                }
                if(cur.right!=null){
                    q.offer(cur.right);
                    map.put(cur.right,cur);
                }
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parent_track=new HashMap<>();
        makeParents(root,parent_track);
        Map<TreeNode,Boolean> visited=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(target);
        visited.put(target,true);
        int cur_lev=0;
        
        while(q.size()>0){
          int len=q.size();
            if(k==cur_lev) break;
            
            cur_lev++;
            for(int i=0; i<len; i++){
                TreeNode cur=q.poll();
                if(cur.left!=null && visited.get(cur.left)==null){
                    q.offer(cur.left);
                    visited.put(cur.left,true);
                }
                if(cur.right!=null && visited.get(cur.right)==null){
                    q.offer(cur.right);
                    visited.put(cur.right,true);
                }
                if(parent_track.get(cur)!=null && visited.get(parent_track.get(cur))==null){
                   q.offer(parent_track.get(cur));
                    visited.put(parent_track.get(cur),true);
                }
                
            }
        }
        List<Integer> arr=new ArrayList<>();
        while(!q.isEmpty()){
            arr.add(q.poll().val);
        }
        return arr;
    }
}
/*

Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its zigzag level order traversal as:

[
  [3],
  [20,9],
  [15,7]
]


*/


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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzagLevelOrderlist = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        if(root==null)
            return zigzagLevelOrderlist;
        s1.push(root);
        while(!s1.isEmpty() || !s2.isEmpty()){
            if(!s1.isEmpty()){
                List<Integer> temp = new ArrayList<>();
                while(!s1.isEmpty()){
                    TreeNode p = s1.pop();
                    temp.add(p.val);
                    if(p.left!=null)
                        s2.push(p.left);
                    if(p.right!=null)
                        s2.push(p.right);
                }                
                zigzagLevelOrderlist.add(temp);
            }
            if(!s2.isEmpty()){
                List<Integer> temp = new ArrayList<>();
                while(!s2.isEmpty()){
                    TreeNode p = s2.pop();
                    temp.add(p.val);
                    if(p.right!=null)
                        s1.push(p.right);
                    if(p.left!=null)
                        s1.push(p.left);
                }
                zigzagLevelOrderlist.add(temp);
            }
        }
        
        return zigzagLevelOrderlist;
    }
    
    
}
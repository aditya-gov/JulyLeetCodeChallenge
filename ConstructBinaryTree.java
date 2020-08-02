/*

Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]

Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7



*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeUtil(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    private TreeNode buildTreeUtil(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd){
        if(inStart > inEnd || postStart > postEnd){
            return null;
        }
        TreeNode node = new TreeNode(postorder[postEnd]);
        int searchIndex = inStart;
        
        while(node.val != inorder[searchIndex]){
            searchIndex++;
        }
        
        int count = searchIndex - inStart;
        node.left = buildTreeUtil(inorder, inStart, searchIndex - 1, postorder, postStart, postStart + count - 1);
        node.right = buildTreeUtil(inorder, searchIndex + 1, inEnd, postorder, postStart + count, postEnd - 1);
        return node;
        
    }
}
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
    public int heightOfBinaryTree(TreeNode root, int[] d)  {
        if(root==null) {
            return 0;
        }
        int left=heightOfBinaryTree(root.left, d);
        int right=heightOfBinaryTree(root.right, d);
        d[0]=Math.max(d[0], (left+right));
        return Math.max(left,right)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int[] d=new int[1];
        heightOfBinaryTree(root, d);
        return d[0];
    }
}
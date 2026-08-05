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
    int count = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return count;     
    }
    public void dfs(TreeNode node, int curMax){
        if(node == null) return;
        if(node.val >= curMax) count++;
        
        int newMax = Math.max(curMax, node.val);

        dfs(node.left, newMax);
        dfs(node.right,newMax);
    }
}

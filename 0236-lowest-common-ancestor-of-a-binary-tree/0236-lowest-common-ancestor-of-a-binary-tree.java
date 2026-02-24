class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if (root == null) return null;
        
        // If current node is p or q
        if (root == p || root == q) {
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // If both sides return non-null, current node is LCA
        if (left != null && right != null) {
            return root;
        }
        
        // Otherwise return non-null side
        return (left != null) ? left : right;
    }
}
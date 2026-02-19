class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }
    
    private boolean isMirror(TreeNode t1, TreeNode t2) {
        // Both null
        if (t1 == null && t2 == null) return true;
        
        // One null
        if (t1 == null || t2 == null) return false;
        
        // Check values and mirror subtrees
        return (t1.val == t2.val) &&
               isMirror(t1.left, t2.right) &&
               isMirror(t1.right, t2.left);
    }
}

import java.util.*;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfs(root, "", result);
        return result;
    }
    
    private void dfs(TreeNode node, String path, List<String> result) {
        if (node == null) return;
        
        // If leaf node
        if (node.left == null && node.right == null) {
            result.add(path + node.val);
            return;
        }
        
        // Continue DFS
        dfs(node.left, path + node.val + "->", result);
        dfs(node.right, path + node.val + "->", result);
    }
}

import java.util.*;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(root, targetSum, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(TreeNode node, int sum, 
                           List<Integer> path, 
                           List<List<Integer>> result) {
        
        if (node == null) return;
        
        path.add(node.val);
        
        // Check if leaf and sum matches
        if (node.left == null && node.right == null && sum == node.val) {
            result.add(new ArrayList<>(path));
        } else {
            backtrack(node.left, sum - node.val, path, result);
            backtrack(node.right, sum - node.val, path, result);
        }
        
        // Backtrack
        path.remove(path.size() - 1);
    }
}

import java.util.*;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int n, int k, List<Integer> current, List<List<Integer>> result) {
        // If combination size is k, add to result
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= n; i++) {
            // Choose
            current.add(i);

            // Explore
            backtrack(i + 1, n, k, current, result);

            // Undo (backtrack)
            current.remove(current.size() - 1);
        }
    }
}
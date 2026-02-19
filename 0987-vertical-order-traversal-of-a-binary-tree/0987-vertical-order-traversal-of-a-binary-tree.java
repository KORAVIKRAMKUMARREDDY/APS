import java.util.*;

class Solution {
    class Tuple {
        TreeNode node;
        int row;
        int col;
        
        Tuple(TreeNode n, int r, int c) {
            node = n;
            row = r;
            col = c;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> list = new ArrayList<>();
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root, 0, 0));
        
        while (!queue.isEmpty()) {
            Tuple t = queue.poll();
            list.add(new int[]{t.col, t.row, t.node.val});
            
            if (t.node.left != null)
                queue.offer(new Tuple(t.node.left, t.row + 1, t.col - 1));
            
            if (t.node.right != null)
                queue.offer(new Tuple(t.node.right, t.row + 1, t.col + 1));
        }
        
        // Sort by col, then row, then value
        Collections.sort(list, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });
        
        List<List<Integer>> result = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;
        
        for (int[] arr : list) {
            if (arr[0] != prevCol) {
                result.add(new ArrayList<>());
                prevCol = arr[0];
            }
            result.get(result.size() - 1).add(arr[2]);
        }
        
        return result;
    }
}

import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        // Step 1: Initialize queue and count fresh oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // If no fresh oranges
        if (fresh == 0) return 0;

        int minutes = 0;

        int[][] directions = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        // Step 2: BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottedThisMinute = false;

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int x = cell[0];
                int y = cell[1];

                for (int[] d : directions) {
                    int nx = x + d[0];
                    int ny = y + d[1];

                    // Check bounds and fresh orange
                    if (nx >= 0 && ny >= 0 && nx < m && ny < n && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;
                        queue.offer(new int[]{nx, ny});
                        fresh--;
                        rottedThisMinute = true;
                    }
                }
            }

            if (rottedThisMinute) {
                minutes++;
            }
        }

        return fresh == 0 ? minutes : -1;
    }
}
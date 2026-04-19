import java.util.*;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Initialize
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    mat[i][j] = -1; // mark unvisited
                }
            }
        }

        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        // Step 2: BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];

            for (int[] d : directions) {
                int nx = x + d[0];
                int ny = y + d[1];

                // Check bounds and unvisited
                if (nx >= 0 && ny >= 0 && nx < m && ny < n && mat[nx][ny] == -1) {
                    mat[nx][ny] = mat[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        return mat;
    }
}
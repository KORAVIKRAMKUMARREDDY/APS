import java.util.*;

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        
        // Step 1: Build graphs
        List<Integer>[] redGraph = new ArrayList[n];
        List<Integer>[] blueGraph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            redGraph[i] = new ArrayList<>();
            blueGraph[i] = new ArrayList<>();
        }

        for (int[] e : redEdges) {
            redGraph[e[0]].add(e[1]);
        }

        for (int[] e : blueEdges) {
            blueGraph[e[0]].add(e[1]);
        }

        // Step 2: Result array
        int[] result = new int[n];
        Arrays.fill(result, -1);

        // Step 3: BFS
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][2]; // 0=red, 1=blue

        // start from node 0 with both possibilities
        queue.offer(new int[]{0, -1, 0});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0];
            int color = curr[1];
            int dist = curr[2];

            // Update result
            if (result[node] == -1) {
                result[node] = dist;
            }

            // If last was not red, go via red
            if (color != 0) {
                for (int next : redGraph[node]) {
                    if (!visited[next][0]) {
                        visited[next][0] = true;
                        queue.offer(new int[]{next, 0, dist + 1});
                    }
                }
            }

            // If last was not blue, go via blue
            if (color != 1) {
                for (int next : blueGraph[node]) {
                    if (!visited[next][1]) {
                        visited[next][1] = true;
                        queue.offer(new int[]{next, 1, dist + 1});
                    }
                }
            }
        }

        return result;
    }
}
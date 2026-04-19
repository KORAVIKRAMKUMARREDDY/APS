import java.util.*;

class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        
        // Step 1: Assign unique groups to -1
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = m++;
            }
        }

        // Graphs
        List<List<Integer>> itemGraph = new ArrayList<>();
        List<List<Integer>> groupGraph = new ArrayList<>();

        int[] itemIndegree = new int[n];
        int[] groupIndegree = new int[m];

        for (int i = 0; i < n; i++) {
            itemGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            groupGraph.add(new ArrayList<>());
        }

        // Step 2: Build graphs
        for (int i = 0; i < n; i++) {
            for (int prev : beforeItems.get(i)) {
                
                // Item graph
                itemGraph.get(prev).add(i);
                itemIndegree[i]++;

                // Group graph
                if (group[i] != group[prev]) {
                    groupGraph.get(group[prev]).add(group[i]);
                    groupIndegree[group[i]]++;
                }
            }
        }

        // Step 3: Topological sort groups
        List<Integer> groupOrder = topoSort(groupGraph, groupIndegree, m);
        if (groupOrder.size() == 0) return new int[0];

        // Step 4: Topological sort items
        List<Integer> itemOrder = topoSort(itemGraph, itemIndegree, n);
        if (itemOrder.size() == 0) return new int[0];

        // Step 5: Group items
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int item : itemOrder) {
            map.computeIfAbsent(group[item], k -> new ArrayList<>()).add(item);
        }

        // Step 6: Build result
        List<Integer> result = new ArrayList<>();
        for (int g : groupOrder) {
            if (map.containsKey(g)) {
                result.addAll(map.get(g));
            }
        }

        // Convert to array
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }

    private List<Integer> topoSort(List<List<Integer>> graph, int[] indegree, int n) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            result.add(curr);

            for (int neighbor : graph.get(curr)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return result.size() == n ? result : new ArrayList<>();
    }
}
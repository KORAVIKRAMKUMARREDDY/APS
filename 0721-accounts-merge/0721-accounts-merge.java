import java.util.*;

class Solution {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind();

        Map<String, String> emailToName = new HashMap<>();

        // Step 1: Union emails
        for (List<String> account : accounts) {
            String name = account.get(0);

            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                emailToName.put(email, name);

                uf.add(email);
                uf.union(account.get(1), email); // connect with first email
            }
        }

        // Step 2: Group emails by root
        Map<String, List<String>> groups = new HashMap<>();

        for (String email : emailToName.keySet()) {
            String root = uf.find(email);
            groups.computeIfAbsent(root, k -> new ArrayList<>()).add(email);
        }

        // Step 3: Build result
        List<List<String>> result = new ArrayList<>();

        for (String root : groups.keySet()) {
            List<String> emails = groups.get(root);
            Collections.sort(emails);

            List<String> account = new ArrayList<>();
            account.add(emailToName.get(root)); // name
            account.addAll(emails);

            result.add(account);
        }

        return result;
    }
}

// Union-Find Class
class UnionFind {
    Map<String, String> parent = new HashMap<>();

    public void add(String x) {
        parent.putIfAbsent(x, x);
    }

    public String find(String x) {
        if (!parent.get(x).equals(x)) {
            parent.put(x, find(parent.get(x))); // path compression
        }
        return parent.get(x);
    }

    public void union(String a, String b) {
        String rootA = find(a);
        String rootB = find(b);

        if (!rootA.equals(rootB)) {
            parent.put(rootA, rootB);
        }
    }
}
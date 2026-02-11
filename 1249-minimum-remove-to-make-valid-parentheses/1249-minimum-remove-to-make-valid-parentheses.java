class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int open = 0;

        // First pass: remove invalid ')'
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                open++;
                sb.append(ch);
            } else if (ch == ')') {
                if (open > 0) {
                    open--;
                    sb.append(ch);
                }
            } else {
                sb.append(ch);
            }
        }

        // Second pass: remove extra '(' from right
        StringBuilder result = new StringBuilder();
        for (int i = sb.length() - 1; i >= 0; i--) {
            char ch = sb.charAt(i);
            if (ch == '(' && open-- > 0) {
                continue;
            }
            result.append(ch);
        }

        return result.reverse().toString();
    }
}
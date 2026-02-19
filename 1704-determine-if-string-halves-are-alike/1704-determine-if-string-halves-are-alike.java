class Solution {
    public boolean halvesAreAlike(String s) {
        String vowels = "aeiouAEIOU";
        int mid = s.length() / 2;
        int countA = 0, countB = 0;

        for (int i = 0; i < mid; i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                countA++;
            }
        }

        for (int i = mid; i < s.length(); i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                countB++;
            }
        }

        return countA == countB;
    }
}

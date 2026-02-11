import java.util.Map; 
import java.util.HashMap; 
class Solution { 
    public int firstUniqChar(String s) { 
        Map<Character, Integer> map = new 
HashMap<>(); 
        // Count frequency of each character 
        for (int i = 0; i < s.length(); i++) { 
            char ch = s.charAt(i); 
            map.put(ch, map.getOrDefault(ch, 0) + 1); 
        } 
        // Find first character with frequency 1 
        for (int i = 0; i < s.length(); i++) { 
            if (map.get(s.charAt(i)) == 1) { 
                return i; 
            } 
        } 
        return -1; 
    } 
    public static void main(String[] args) { 
        Solution s = new Solution(); 
        System.out.println(s.firstUniqChar("leetcode"));     
// 0 
        
System.out.println(s.firstUniqChar("loveleetcode")); 
        System.out.println(s.firstUniqChar("aabb"));         
// -1 
    } 
} 
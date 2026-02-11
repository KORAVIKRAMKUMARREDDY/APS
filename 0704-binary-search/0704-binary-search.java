import java.util.Arrays; 
class Solution { 
    public int search(int[] nums, int target) { 
        int left = 0; 
        int right = nums.length - 1; 
        while (left <= right) { 
            int mid = left + (right - left) / 2; 
            if (nums[mid] == target) { 
                return mid; 
            } 
            if (target < nums[mid]) { 
                right = mid - 1; 
            } else { 
                left = mid + 1; 
            } 
        } 
        return -1; 
    } 
 
    public static void main(String[] args) { 
        Solution s = new Solution(); 
        int[] nums = {-1, 0, 3, 5, 9, 12}; 
        int target = 9; 
        System.out.println(s.search(nums, target)); 
    } 
} 
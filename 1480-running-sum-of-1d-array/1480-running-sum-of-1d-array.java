import java.util.Arrays; 
class Solution { 
    public int[] runningSum(int[] nums) { 
        for (int i = 1; i < nums.length; i++) { 
            nums[i] = nums[i] + nums[i - 1]; 
        } 
        return nums; 
    } 
    public static void main(String[] args) { 
        Solution s = new Solution(); 
        int[] nums = {1, 2, 3, 4};    
System.out.println(Arrays.toString(s.runningSum(nums))); 
    } 
} 
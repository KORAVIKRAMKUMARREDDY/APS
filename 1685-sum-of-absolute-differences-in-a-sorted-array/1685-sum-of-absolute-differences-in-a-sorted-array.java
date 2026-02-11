import java.util.Arrays; 
class Solution { 
    public int[] getSumAbsoluteDifferences(int[] nums) 
{ 
        int n = nums.length; 
        int[] ans = new int[n]; 
 
        int totalSum = 0; 
        for (int num : nums) { 
            totalSum += num; 
        } 
        int leftSum = 0; 
        for (int i = 0; i < n; i++) { 
            int rightSum = totalSum - leftSum - nums[i]; 
            ans[i] = nums[i] * i - leftSum 
                   + rightSum - nums[i] * (n - i - 1); 
            leftSum += nums[i]; 
        } 
        return ans; 
    } 
    public static void main(String[] args) { 
        Solution s = new Solution(); 
        int[] nums = {2, 3, 5};     
System.out.println(Arrays.toString(s.getSumAbsoluteDifferences(nums))); 
    } 
}
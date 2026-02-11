import java.util.Arrays; 
 
class Solution { 
 
    public void moveZeroes(int[] nums) { 
 
        int insertPosition = 0; 
 
        for (int i = 0; i < nums.length; i++) { 
            if (nums[i] != 0) { 
                nums[insertPosition++] = nums[i]; 
            } 
        } 
 
        while (insertPosition < nums.length) { 
            nums[insertPosition++] = 0; 
        } 
    } 
 
    public static void main(String[] args) { 
        Solution s = new Solution(); 
        int[] nums = {0, 1, 0, 3, 12}; 
 
        s.moveZeroes(nums); 
        System.out.println(Arrays.toString(nums)); 
    } 
} 

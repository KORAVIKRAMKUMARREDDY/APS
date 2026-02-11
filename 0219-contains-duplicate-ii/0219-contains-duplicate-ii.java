class Solution
 {
    public boolean containsNearbyDuplicate(int[] nums, int k)
     {
        Map<Integer, Integer> m = new HashMap<>();
	for(int i=0;i<nums.length;i++)
	{
	if (m.containsKey(nums[i])) 
	{
	int diff = i - m.get(nums[i]);
	if (diff <= k) 
	{
	return true;
	}}
        m.put(nums[i],i);
        //System.out.println(m);  
        }
	return false;  
       }
    
}

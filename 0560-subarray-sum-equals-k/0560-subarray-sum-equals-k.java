class Solution {
    public int subarraySum(int[] nums, int k) {
       int  count=0;
       for(int left=0;left<nums.length;left++){
        int sum=0;
        for(int right=left;right<nums.length;right++){
            sum=sum+nums[right];
            if(sum==k){

            
            count++;
            }
        }
       }
       return count;
    }
}
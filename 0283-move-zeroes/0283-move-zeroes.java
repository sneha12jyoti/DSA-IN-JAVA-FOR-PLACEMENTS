class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int left=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]!=0){
         swap(nums,left,right);
         left++;
            }
        }
    }
       public void swap(int nums[],int start,int end){
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
       } 
    
}
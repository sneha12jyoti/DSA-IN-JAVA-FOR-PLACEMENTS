class Solution {
    public void moveZeroes(int[] nums) {
        int left=0;
        int n=nums.length;
        for(int right=0;right<n;right++){
            if(nums[right]!=0){
                swap(nums,left,right);
                left++;
            }
        }
    }
    public void swap(int nums[],int left,int right){
         while(left<right){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;

        
    }
    }
}
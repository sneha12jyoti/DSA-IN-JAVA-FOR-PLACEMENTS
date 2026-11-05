class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first=firstsearch(nums,target);
        int second=lastsearch(nums,target);
        return new int[]{first,second};
    }
        public static int firstsearch(int nums[],int target){
        int n=nums.length;
        int left=0;
        int right=n-1;
        int ans=-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                ans=mid;
                right=mid-1;
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
       return ans;
    }
    public static int lastsearch(int nums[],int target){
        int n=nums.length;
        int left=0;
        int ans=-1;
        int right=n-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                ans=mid;
                left=mid+1;
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }

      return ans;
    }
    
}
class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        for(int candidate=0;candidate<=n;candidate++){
            boolean found=false;
            for(int value:nums){
                if(value==candidate){
                    found=true;
                    break;
                }
            }
            if(!found){
                return candidate;
            }
        }
        return -1;
    }
}
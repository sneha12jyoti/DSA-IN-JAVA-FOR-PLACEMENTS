class Solution {
    public int[] unionArray(int[] nums1, int[] nums2) {
        Set<Integer> unionset=new TreeSet<>();
        for(int value:nums1){
            unionset.add(value);
        }
        for(int value:nums2){
            unionset.add(value);
        }
        int result[]=new int[unionset.size()];
       int i=0;
       for(int value:unionset){
        result[i]=value;
        i++;
       }
       return result;
    }
}

class Solution {
    public int findIndex(List <Integer> nums, int val) {
        int index=Collections.binarySearch(nums, val);
        if(index<0) {
            index=-index-1;
        }
        return index;
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> merged=new ArrayList<>();
        for(int i: nums1) {
            merged.add(i);
        }
        for(int i=0;i<nums2.length;i++) {
            int index=findIndex(merged, nums2[i]);
            merged.add(index, nums2[i]);
        }
        double res=0;
        int len=merged.size()/2;
        if(merged.size()%2==0) {
            res=((double)merged.get(len)+(double)merged.get(len-1))/2;
            return res;
        }
        return (double)merged.get(len);
    }
}
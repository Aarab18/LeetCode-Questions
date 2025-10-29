class Solution {
    public int[] merge(int[] nums1, int[] nums2) {
        int res[]=new int[nums1.length+nums2.length];
        int index=0;
        int i=0,j=0;
        while(i<nums1.length && j<nums2.length) {
            if((i<nums1.length && j<nums2.length) && nums1[i]>=nums2[j]) {
                res[index++]=nums2[j++];
            }
            if((i<nums1.length && j<nums2.length) && nums2[j]>nums1[i]) {
                res[index++]=nums1[i++];
            }
        }
        while(i<nums1.length) {
            res[index++]=nums1[i++];
        }
        while(j<nums2.length) {
            res[index++]=nums2[j++];
        }
        return res;
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] res=new int[nums1.length+nums2.length];
        res=merge(nums1, nums2);
        System.out.println(Arrays.toString(res));
        if(res.length%2==0) {
            double num1=res[res.length/2]+res[res.length/2-1];
            num1=num1/2;
            return num1;
        }
        double num2=res[res.length/2];
        return num2;
    }
}
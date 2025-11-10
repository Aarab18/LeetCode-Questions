class Solution {
    public boolean check(int[] nums) {
        int n=nums.length;
        int[] copy=new int[n];
        for(int i=0;i<n;i++) {
           copy[i]=nums[i];
        }
        Arrays.sort(copy);
        int index=0;
        for(int i=0;i<n;i++) {
            if(nums[i]==copy[0] && (i-1)>=0 && nums[i]<nums[i-1]) {
                index=i;
                break;
            }
        }
        for(int i=0;i<n;i++) {
            if(copy[i]!=nums[(i+index)%n]) {
                return false;
            }
        }
        return true;
    }
}
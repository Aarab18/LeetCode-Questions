class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int actualSum=(n*(n+1))/2;
        int observedSum=0;
        for(int num : nums) {
            observedSum+=num;
        }
        return actualSum-observedSum;
    }
}
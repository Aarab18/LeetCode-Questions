class Solution {
    public int maxSubArray(int[] nums) {
        int max=0, res=Integer.MIN_VALUE;
        for(int i : nums) {
            max=Math.max(i, max+i);
            res=Math.max(max, res);
        }
        return res;
    }
}
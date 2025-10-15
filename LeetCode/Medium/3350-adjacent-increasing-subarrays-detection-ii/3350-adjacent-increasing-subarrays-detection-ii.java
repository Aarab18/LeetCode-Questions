class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int up = 1, last = 0, ans = 0;
        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                up++;
            } else {
                last = up;
                up = 1;
            }
            int half = up/2;
            int min = Math.min(last,up);
            int val = half > min ? half : min;
            if (val > ans) ans = val;
        }
        return ans;
    }
}
class Solution {
    public int trap(int[] height) {
        int left = 1;
        int right = height.length - 2;
        int leftMax = height[left - 1];
        int rightMax = height[right + 1];
        int result = 0;
        while (left <= right) {
            if (rightMax <= leftMax) {
                result += Math.max(0, rightMax - height[right]);
                rightMax = Math.max(rightMax, height[right]);
                right--;
            } else { 
                result += Math.max(0, leftMax - height[left]);
                leftMax = Math.max(leftMax, height[left]);
                left++;
            }
        }
        return result;
    }
}
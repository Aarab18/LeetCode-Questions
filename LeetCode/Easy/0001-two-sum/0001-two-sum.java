class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indices=new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            int rem=target-nums[i];
            if(indices.containsKey(rem)) {
                return new int[]{indices.get(rem), i};
            }
            indices.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
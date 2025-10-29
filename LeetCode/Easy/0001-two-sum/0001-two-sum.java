class Solution {
    public int[] twoSum(int[] nums, int target) {
        int remSum=0;
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            remSum=target-nums[i];
            if(map.containsKey(remSum)) {
                return new int[]{i, map.get(remSum)};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }
}
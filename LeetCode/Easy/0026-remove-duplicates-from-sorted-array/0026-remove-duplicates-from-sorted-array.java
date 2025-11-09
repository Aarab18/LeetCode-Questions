class Solution {
    public int removeDuplicates(int[] nums) {
        Map<Integer, Integer> map=new LinkedHashMap<>();
        for(int num : nums) {
            if(!map.containsKey(num)) {
                map.put(num, 1);
            }
        }
        System.out.println(map);
        int index=0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            nums[index++]=entry.getKey();
        }
        return index;
    }
}
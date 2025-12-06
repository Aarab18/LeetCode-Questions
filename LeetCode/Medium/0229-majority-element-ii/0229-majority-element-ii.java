class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map=new HashMap<>();
        Set<Integer> set=new HashSet<>();
        List<Integer> majority=new ArrayList<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
            if(map.get(num)>nums.length/3) {
                set.add(num);
            }
        }
        for(int num : set) {
            majority.add(num);
        }
        return majority;
    }
}
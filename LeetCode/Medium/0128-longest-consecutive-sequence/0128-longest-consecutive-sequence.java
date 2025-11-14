class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) {
            return 0;
        }
        Map<Integer, Integer> map=new TreeMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        List<Integer> keys = new ArrayList<>(map.keySet());
        int max=1, count=1;;
        for(int i=0;i<keys.size()-1;i++) {
            if(keys.get(i)+1==keys.get(i+1)) {
                count++;
            }
            max=Math.max(count, max);
            if(keys.get(i)+1!=keys.get(i+1)) {
                count=1;
            }
        }
        return max;
    }
}
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        int maxLen=0;
        for(int num : set) {
            if(!set.contains(num-1)) {
                int currNum=num+1;
                int length=1;
                while(set.contains(currNum)) {
                    currNum++;
                    length++;
                }
                maxLen=Math.max(length, maxLen);
            }
        }
        return maxLen;
    }
}
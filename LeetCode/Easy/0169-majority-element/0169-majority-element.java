class Solution {
    public int majorityElement(int[] nums) {
        int count=0, majority=0;
        for(int num : nums) {
            if(count==0) {
                majority=num;
            }
            if(majority==num) {
                count++;
            }
            else {
                count--;
            }
        }
        return majority;
    }
}
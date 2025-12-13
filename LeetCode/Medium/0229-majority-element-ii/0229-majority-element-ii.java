class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1=0, count2=0;
        int val1=Integer.MIN_VALUE, val2=Integer.MIN_VALUE;
        for(int num : nums) {
            if(count1==0 && val2!=num) {
                count1=1;
                val1=num;
            }
            else if(count2==0 && val1!=num) {
                count2=1;
                val2=num;
            }
            else if(val1==num) {
                count1++;
            }
            else if(val2==num) {
                count2++;
            }
            else {
                count1--;
                count2--;
            }
        }
        count1=0; count2=0;
        for(int num : nums) {
            if(num==val1) {
                count1++;
            }
            if(num==val2) {
                count2++;
            }
        }
        List<Integer> list=new ArrayList<>();
        if(count1>nums.length/3) {
            list.add(val1);
        }
        if(count2>nums.length/3) {
            list.add(val2);
        }
        return list;
    }
}
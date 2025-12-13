class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int first=0, second=0;
        int cFirst=0, cSecond=0;
        for(int num : nums) {
            if(cFirst==0 && second!=num) {
                first=num;
                cFirst=1;
            }
            else if(cSecond==0 && first!=num) {
                second=num;
                cSecond=1;
            }
            else if(first==num) {
                cFirst++;
            }
            else if(second==num) {
                cSecond++;
            }
            else {
                cFirst--;
                cSecond--;
            }
        }
        cFirst=0;
        cSecond=0;
        for(int num : nums) {
            if(num==first) {
                cFirst++;
            }
            else if(num==second) {
                cSecond++;
            }
        }
        List<Integer> majority=new ArrayList<>();
        if(cFirst>nums.length/3) {
            majority.add(first);
        }
        if(cSecond>nums.length/3) {
            majority.add(second);
        }
        return majority;
    }
}
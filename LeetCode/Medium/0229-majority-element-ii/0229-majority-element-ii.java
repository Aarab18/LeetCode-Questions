class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int first=0, second=0;
        int countFirst=0, countSecond=0;
        for(int num : nums) {
            if(countFirst==0 && second!=num) {
                first=num;
                countFirst=1;
            }
            else if(countSecond==0 && first!=num) {
                second=num;
                countSecond=1;
            }
            else if(first==num) {
                countFirst++;
            }
            else if(second==num) {
                countSecond++;
            }
            else {
                countFirst--;
                countSecond--;
            }
        }
        countFirst=0;
        countSecond=0;
        for(int num : nums) {
            if(num==first) {
                countFirst++;
            }
            else if(num==second) {
                countSecond++;
            }
        }
        List<Integer> majority=new ArrayList<>();
        if(countFirst>nums.length/3) {
            majority.add(first);
        }
        if(countSecond>nums.length/3) {
            majority.add(second);
        }
        return majority;
    }
}
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int positive=0, negative=1;
        int[] modified=new int[nums.length];
        for(int num : nums) {
            if(num>=0) {
                modified[positive]=num;
                positive+=2;
            }
            else {
                modified[negative]=num;
                negative+=2;
            }
        }
        return modified;
    }
}
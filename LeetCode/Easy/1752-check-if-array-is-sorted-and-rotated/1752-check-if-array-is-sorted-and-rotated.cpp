class Solution {
public:
    bool check(vector<int>& nums) {
        int count=0, index=0;
        if(nums.size()==1){
            return true;
        }
        for(int i=0;i<nums.size()-1;i++){
            if(nums[i]>nums[i+1]){
                count++;
                index=i+1;
            }
        }
        if(count>1){
            return false;
        }
        else if(count==1){
            if(nums[nums.size()-1]<=nums[0]){
                return true;
            }
            else{
                return false;
            }
        }
        return true;
    }
};
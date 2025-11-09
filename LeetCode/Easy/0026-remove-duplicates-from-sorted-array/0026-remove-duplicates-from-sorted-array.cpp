class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int count=0;
        vector <int> res;
        for(int i=0;i<nums.size();i++){
            res.push_back(nums[i]);
        }
        while(nums.size()>0){
            nums.pop_back();
        }
        for(int i=0;i<res.size();i++){
            int j;
            for(j=0;j<res.size();j++){
                if(res[i]==res[j]){
                    break;
                }
            }
            if(i==j){
                nums.push_back(res[i]);
                count++;
            }
        }
        return count;
    }
};
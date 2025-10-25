class Solution {
    public int totalMoney(int n) {
        int sum=0, start=1, count=0, counts=0;
        for(int i=0;i<n;i++) {
            sum+=(start+i);
            count++;
            counts++;
            if(count==7) {
                start++;
                i=-1;
                count=0;
            }
            if(counts>=n) {
                return sum;
            }
        }
        return sum;
    }
}
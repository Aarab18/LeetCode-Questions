class Solution {
    public int[] getNoZeroIntegers(int n) {
        int a=0, b=0;
        for(int i=1;i<n;i++) {
            a=i;
            b=n-i;
            String first=String.valueOf(a);
            String second=String.valueOf(b);
            if(!first.contains("0") && !second.contains("0")) {
                return new int[]{a,b};
            }
        }
        return new int[]{};
    }
}
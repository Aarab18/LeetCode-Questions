class Solution {
    public int minDistance(String word1, String word2) {
        int n1=word1.length(), n2=word2.length();
        int dp[][]=new int[n1+1][n2+1];
        for(int i=0;i<dp[0].length;i++) {
            dp[0][i]=i;
        }
        for(int i=0;i<dp.length;i++) {
            dp[i][0]=i;
        }
        for(int i=1;i<dp.length;i++) {
            for(int j=1;j<dp[0].length;j++) {
                if(word1.charAt(i-1)==word2.charAt(j-1)) {
                    dp[i][j]=dp[i-1][j-1];
                }
                else{
                    dp[i][j]=1+Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[n1][n2];
    }
}
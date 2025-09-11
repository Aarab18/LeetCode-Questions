class Solution {
    public int countWays(int i, int j, int m, int n) {
        if(i==m-1 && j==n-1) {
            return 1;
        }
        if(i>=m || j>=n) {
            return 0;
        }
        return countWays(i+1, j, m, n) + countWays(i, j+1, m, n);
    }
    public int uniquePaths(int m, int n) {
        int ways=countWays(0, 0, m, n);
        return ways;
    }
}
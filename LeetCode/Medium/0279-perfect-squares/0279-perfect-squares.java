class Solution {
    public boolean isPerfectSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
    public int findFourSquares(int n) {
        int count=0;
        for (int a = 0; a * a <= n; a++) {
            for (int b = a; a * a + b * b <= n; b++) {
                for (int c = b; a * a + b * b + c * c <= n; c++) {
                    int d2 = n - (a * a + b * b + c * c);
                    if (isPerfectSquare(d2)) {
                        int d = (int) Math.sqrt(d2);
                        if(a!=0) {
                            count++;
                        } if(b!=0) {
                            count++;
                        } if(c!=0) {
                            count++;
                        } if(d!=0) {
                            count++;
                        }
                        return count;
                    }
                }
            }
        }
        return count;
    }
    public int numSquares(int n) {
        return findFourSquares(n);
    }
}
import java.util.stream.*;
class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n=piles.length;
        int self=n-2;
        Set<Integer> set=new HashSet<>();
        int mySum=0;
        for(int i=0;i<n/3;i++) {
            mySum+=piles[self];
            self-=2;
        }
        return mySum;
    }
}
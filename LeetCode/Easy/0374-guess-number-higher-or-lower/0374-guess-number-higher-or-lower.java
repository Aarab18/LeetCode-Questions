/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        long start=1, end=n;
        while(start<=end) {
            long mid=(end+start)/2;
            int ans = guess((int)mid);
            if(ans == -1) {
                end=mid-1;
            }
            else if(ans == 1) {
                start=mid+1;
            }
            else {
                return (int)mid;
            }
        }
        return 0;
    }
}
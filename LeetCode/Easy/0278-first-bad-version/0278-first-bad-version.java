/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long start=1, end=n;
        while(start<end) {
            long mid = start + (end - start) / 2;
            if (isBadVersion((int)mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return (int)start;
    }
}
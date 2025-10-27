class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingDouble(o->o[1]));
        int prev=Integer.MIN_VALUE, count=0;
        for(int i=0;i<intervals.length;i++) {
            if(prev==Integer.MIN_VALUE) {
                count++;
                prev=intervals[i][1];
            }
            else {
                if(intervals[i][0]>=prev) {
                    count++;
                    prev=intervals[i][1];
                }
            }
        }
        return intervals.length-count;
    }
}
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        System.out.println(Arrays.deepToString(boxTypes));
        int size=0;
        int unit=0;
        for(int i=0;i<boxTypes.length;i++) {
            if(size+boxTypes[i][0]>truckSize) {
                unit+=(truckSize-size)*boxTypes[i][1];
                size+=truckSize-size;
            }
            else {
                unit+=boxTypes[i][1]*boxTypes[i][0];
                size+=boxTypes[i][0];
            }
        } 
        return unit;
    }
}
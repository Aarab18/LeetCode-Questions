class Solution {
    public int numberOfBeams(String[] bank) {
        int prev=0;
        int sum=0;
        for(String str : bank) {
            int current=0;
            for(char ch : str.toCharArray()) {
                if(ch=='1') {
                    current++;
                }
            }
            if(current!=0) {
                sum+=(current*prev);
                prev=current;
            }
        }
        System.out.println(sum);
        return sum;
    }
}
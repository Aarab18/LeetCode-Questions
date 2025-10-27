class Solution {
    public int numberOfBeams(String[] bank) {
        List<Integer> ones=new ArrayList<>();
        for(String str : bank) {
            int count=0;
            for(char ch : str.toCharArray()) {
                if(ch=='1') {
                    count++;
                }
            }
            if(count!=0) {
                ones.add(count);
            }
        }
        System.out.println(ones);
        if(ones.size()<=1) {
            return 0;
        }
        int sum=0;
        for(int i=0;i<ones.size()-1;i++) {
            sum+=(ones.get(i)*ones.get(i+1));
        }
        return sum;
    }
}
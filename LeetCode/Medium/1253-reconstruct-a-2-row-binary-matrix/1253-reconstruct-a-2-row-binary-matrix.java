class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> row1=new ArrayList<>();
        List<Integer> row2=new ArrayList<>();
        for(int column : colsum) {
            if(column==2) {
                row1.add(1);
                row2.add(1);
                upper--;
                lower--;
            }
            else if(column==1) {
                if(upper>=lower) {
                    row1.add(1);
                    row2.add(0);
                    upper--;
                }
                else {
                    row1.add(0);
                    row2.add(1);
                    lower--;
                }
            }
            else {
                row1.add(0);
                row2.add(0);
            }
            if(upper<0 && lower<0) {
                return new ArrayList<>();
            }
        }
        if(upper!=0 || lower!=0) {
            return new ArrayList<>();
        }
        res.add(row1);
        res.add(row2);
        return res;
    }
}
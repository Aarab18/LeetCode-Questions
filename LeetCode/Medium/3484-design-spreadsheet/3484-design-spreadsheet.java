class Spreadsheet {

    Map<String, Integer> map;

    public Spreadsheet(int rows) {
        map = new HashMap<>();
    }
    
    public void setCell(String cell, int value) {
        map.put(cell, value);
    }
    
    public void resetCell(String cell) {
        map.remove(cell);
    }
    
    public int getValue(String formula) {
        String[] nums = formula.split("\\+");
        return getNum(nums[0].substring(1)) + getNum(nums[1]);
    }

    private int getNum(String num) {
        if('A' <= num.charAt(0) && num.charAt(0) <= 'Z') {
            return map.getOrDefault(num, 0);
        }
        return Integer.parseInt(num);
    }
}
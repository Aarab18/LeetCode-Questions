class Solution {
    public boolean hasSameDigits(String s) {
        while(s.length()!=2) {
            String str="";
            int i=1;
            while(i<s.length()) {
                int num1=s.charAt(i-1);
                int num2=s.charAt(i);
                int toAdd=(num1+num2)%10;
                str+=String.valueOf(toAdd);
                i++;
            }
            s=str;
        }
        return s.charAt(0)==s.charAt(1);
    } 
}
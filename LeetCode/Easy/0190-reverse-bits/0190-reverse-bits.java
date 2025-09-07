class Solution {
    public int reverseBits(int n) {
        String bits="";
        while(n!=0) {
            bits+=String.valueOf(n%2);
            n/=2;
        }
        while(bits.length()!=32) {
            bits+="0";
        }
        int power=0;
        for(int i=bits.length()-1;i>=0;i--) {
            int num=bits.charAt(i)=='0'?0:1;
            n+=num*Math.pow(2, power);
            power++;
        }
        System.out.println(bits);
        return n;
    }
}
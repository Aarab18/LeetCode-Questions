class Solution {
    public void reverseRecursion(char[] s, int start, int end) {
        if(start>=end) {
            return;
        }
        char temp=s[start];
        s[start]=s[end];
        s[end]=temp;
        reverseRecursion(s, start+1, end-1);
    }
    public void reverseString(char[] s) {
        int start=0, end=s.length-1;
        reverseRecursion(s, start, end);
    }
}
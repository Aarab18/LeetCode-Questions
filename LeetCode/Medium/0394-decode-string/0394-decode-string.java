class Solution {
    public String decodeString(String s) {
        Stack<Integer> counts=new Stack<>();
        Stack<String> resultant=new Stack<>();
        StringBuilder curr=new StringBuilder();
        int k=0;
        for(char ch : s.toCharArray()) {
            if(Character.isDigit(ch)) {
                k=k*10+ch-'0';
            }
            else if(ch=='[') {
                counts.push(k);
                resultant.push(curr.toString());
                curr=new StringBuilder();
                k=0;
            }
            else if(ch==']') {
                int count=counts.pop();
                StringBuilder temp=new StringBuilder(resultant.pop());
                for(int i=0;i<count;i++) {
                    temp.append(curr);
                }
                curr=temp;
            }
            else if(Character.isLetter(ch)) {
                curr.append(ch);
            }
        }
        return curr.toString(); 
    }
}
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        char arr[]=s.toCharArray();
        int count=0;
        for(char ch:arr){
            if(ch=='(' || ch=='[' || ch=='{'){
                st.push(ch);
            }
            else{
                if(st.isEmpty()){
                    return false;
                }
                else if(st.peek()=='{' && ch=='}' || st.peek()=='(' && ch==')' || st.peek()=='[' && ch==']'){
                    st.pop();
                }
                else{
                    return false;
                }
            }
        }
        if(st.isEmpty()){
            return true;
        }
        return false;
    }
}
class Solution {
    public List<String> Parentheses(int n, int open, int close, List<String> answer, StringBuilder res) {
        if(open==close && close==n) {
            answer.add(res.toString());
            return answer;
        }
        if(open<n) {
            res.append("(");
            Parentheses(n, open+1, close, answer, res);
            res.deleteCharAt(res.length()-1);
        }
        if(close<open) {
            res.append(")");
            Parentheses(n, open, close+1, answer, res);
            res.deleteCharAt(res.length()-1);
        }
        return answer;
    }
    public List<String> generateParenthesis(int n) {
        List<String> answer=new ArrayList<>();
        StringBuilder res=new StringBuilder();
        return Parentheses(n, 0, 0, answer, res);
    }
}
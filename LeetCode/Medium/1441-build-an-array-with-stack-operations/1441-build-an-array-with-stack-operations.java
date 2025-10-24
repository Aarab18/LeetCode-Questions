class Solution {
    public List<String> buildArray(int[] target, int n) {
        ArrayList<String> operations=new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
        for(int i=1;i<=n;i++) {
            stack.push(i);
            operations.add("Push");
            if((i-1)<target.length && stack.peek()!=target[i-1]) {
                operations.add("Pop");
                stack.pop();
            }
            if(stack.size()==target.length) {
                return operations;
            }
        }
        return operations;
    }
}
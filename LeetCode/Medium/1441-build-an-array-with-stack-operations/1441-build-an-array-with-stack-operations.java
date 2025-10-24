class Solution {
    public List<String> buildArray(int[] target, int n) {
        ArrayList<String> operations=new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
        int count=0;
        int index=0;
        int numToPush=1;
        while(count!=target.length) {
            stack.push(numToPush);
            operations.add("Push");
            if(stack.peek()==target[index]) {
                count++;
                index++;
            }
            else {
                stack.pop();
                operations.add("Pop");
            }
            numToPush++;
        }
        return operations;
    }
}
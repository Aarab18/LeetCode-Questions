class Solution {
    public int trap(int[] arr) {
        Stack<Integer> s=new Stack<>();
        int water=0;
        for(int i=0;i<arr.length;i++) {
            while(!s.isEmpty() && arr[i]>arr[s.peek()]) {
                int bottom=s.pop();
                if(s.isEmpty()) {
                    break;
                }
                int h=i-s.peek()-1;
                int w=Math.min(arr[s.peek()], arr[i])-arr[bottom];
                water+=(h*w);
            }
            s.push(i);
        }
        return water;
    }
}
class CustomStack {
    int maxSize;
    int top;
    int arr[];
    private int size;
    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        top = -1;
        arr = new int[maxSize];
    }
    
    public void push(int x) {
        if(top >= maxSize-1){
            return;
        }
        arr[++top] = x;
        size++;
    }
    
    public int pop() {
        if(top<0){
            return -1;
        }
        size--;
        return arr[top--];
    }
    
    public void increment(int k, int val) {
        int limit = Math.min(k, size);
        for (int i = 0; i < limit; i++) {
            arr[i] += val;
        }
    } 
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
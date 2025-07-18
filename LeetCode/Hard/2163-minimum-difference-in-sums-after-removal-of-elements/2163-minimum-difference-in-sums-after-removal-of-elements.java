class Solution {
    
    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        Comparator<Integer> maxComparator = new Comparator<Integer>(){
            @Override
            public int compare(Integer i, Integer j){
                return - i.compareTo(j);
            }
        };
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(n, maxComparator);
        long sum = 0;
        
        for (int i = 0; i < n; i++){
            maxHeap.offer(nums[i]);
            sum += nums[i];
        }
        
        long prefix[] = new long[n + 1];
        prefix[0] = sum;
        
        for (int i = 1; i <= n; i++) {
            if (maxHeap.peek() > nums[n + i - 1]) {
                
                prefix[i] = prefix[i - 1] + nums[n + i - 1] - maxHeap.poll();
                maxHeap.offer(nums[n + i - 1]);
            }
            else { prefix[i] = prefix[i - 1]; }
        }
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(n);
        sum = 0;
        
        for (int i = 0; i < n; i++){
            minHeap.offer(nums[nums.length - 1 - i]);
            sum += nums[nums.length - 1 - i];
        }
        
        long ans = prefix[n] - sum;
        for (int i = 0; i < n; i++) {
            
            int num = nums[nums.length - (n + 1) - i];
            if (minHeap.peek() < num) {
                sum -= minHeap.poll() - num;
                minHeap.offer(num);
            }
            
            ans = Math.min(ans, prefix[n - (i + 1)] - sum);
        }
        
        return ans;
        
    }
}
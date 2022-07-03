class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
         PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }
        
         int result = 0;
         for (int i = 0; i < k; i++) {
             result = pq.poll();
         }
        return result;
    }
}
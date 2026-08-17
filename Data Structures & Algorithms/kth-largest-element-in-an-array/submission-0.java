class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pp = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            if (pp.size() < k)
                pp.offer(nums[i]);
            else if (pp.peek() < nums[i]) {
                pp.poll();
                pp.offer(nums[i]);
            }
        }
        return pp.peek();
    }
}
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || k <= 0) return new int[0];
        
        int n = nums.length;
        int[]res = new int[n - k + 1];
        int idx = 0;

        Deque<Integer> de = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            while(!de.isEmpty() && de.peek() < i - k + 1){
                de.poll();
            }
            while(!de.isEmpty() && nums[de.peekLast()] < nums[i]){
                de.pollLast();
            }

            de.offer(i);
            if( i >= k - 1) res[idx++] = nums[de.peek()];
        }
        return res;
    }
}
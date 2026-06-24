class Solution {
    public int rob(int[] nums) {
        int rob1 = 0;
        int maxRob = 0;

        for(int currVal: nums){
            int temp = Math.max(maxRob, rob1 + currVal);
            rob1 = maxRob;
            maxRob = temp;
        }

        return maxRob;
        
    }
}

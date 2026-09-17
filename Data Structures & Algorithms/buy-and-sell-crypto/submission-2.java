class Solution {
    public int maxProfit(int[] prices) {
        int l = 0, r = l + 1;
        int max = 0;

        while (r < prices.length){
            int profit = 0;
            if(prices[l] < prices[r]){
                profit = prices[r] - prices[l];
                max = Math.max(max, profit);
            }else{
                l = r;
            }
            r++;
        }
        return max;
    }
}

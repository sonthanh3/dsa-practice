class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 1;
        int right = 0;
        for(int w: weights){
            left = Math.max(left, w);
            right += w;
        }
        while(left < right){
            int mid = left + (right - left) / 2;
            if(getDays(weights, mid) <= days) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    public int getDays(int[]weights, int cap){
        int days = 1;
        int cur = 0;
        for(int i = 0; i < weights.length; i++){
            if(cur + weights[i] > cap){
                days++;
                cur = 0;
            }
            cur += weights[i];
        }
        return days;
    }
    
}

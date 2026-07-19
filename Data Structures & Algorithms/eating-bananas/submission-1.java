class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        for(int i = 0; i < piles.length; i++){
            if(piles[i] > r) r = piles[i];
        }

        while(l < r){
            int mid = l + (r - l) / 2;
            if(totalHours(piles, mid) <= h) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    public int totalHours(int[]piles,int k){
        int total = 0;
        for(int i = 0; i < piles.length; i++){
            total += (piles[i] + k - 1) / k;
        }
        return total;
    }
}

class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int window = 0;
        int target = threshold * k;
        for (int i = 0; i < k; i++) {
            window += arr[i];
        }

        if (window >= target)
            count++;

        for (int i = k; i < arr.length; i++) {
            window += arr[i] - arr[i - k];

            if (window >= target)
                count++;

        }
        return count;
    }
}
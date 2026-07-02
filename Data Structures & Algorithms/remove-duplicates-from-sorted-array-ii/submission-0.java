class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n;
        int i = 0;
        while (i < n - 1) {
            if (nums[i] == nums[i + 1]) {
                int j = i + 2, cnt = 0;
                while (j < n && nums[i] == nums[j]) {
                    j++;
                    cnt++;
                }
                for (int k = i + 2; k < n; k++) {
                    if (j >= n) break;
                    nums[k] = nums[j++];
                }
                n -= cnt;
                i += 2;
            } else {
                i++;
            }
        }
        return n;
    }
}
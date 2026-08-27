class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        // Bước 1: Phân loại
        for (int num : nums) {
            if (num > 0) pos.add(num);
            else neg.add(num);
        }

        // Bước 2: Ghép xen kẽ
        int[] res = new int[n];
        for (int i = 0; i < n / 2; i++) {
            res[2 * i] = pos.get(i);
            res[2 * i + 1] = neg.get(i);
        }

        return res;
    }
}
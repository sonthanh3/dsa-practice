class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subsets = new ArrayList<>();

        createSubsets(nums, 0, res, subsets);
        return res;
        
    }
    
    private void createSubsets(int []nums, int index, List<List<Integer>> res, List<Integer> subsets){
        if(index == nums.length){
            res.add(new ArrayList<>(subsets));
            return;
        }

        subsets.add(nums[index]);
        createSubsets(nums, index + 1, res, subsets);

        subsets.remove(subsets.size() - 1);
        createSubsets(nums, index + 1, res, subsets);

    }
}
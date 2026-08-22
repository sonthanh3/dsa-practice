class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> perms = new ArrayList<>();
        perms.add(new ArrayList<>());

        for(int num: nums){
            List<List<Integer>> newPerms = new ArrayList<>();

            for(List<Integer> p: perms){
                for(int i = 0; i <= p.size(); i++){
                    List<Integer> pCopy = new ArrayList<>(p);
                    pCopy.add(i, num);
                    newPerms.add(pCopy);
                }
            }
            perms = newPerms;
        }
        return perms;
    }
}
/*

Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]



*/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        List<Integer> subSet = new ArrayList<>();
        findPowetSet(nums,res,subSet,0);
        return res;
    }
    
    private void findPowetSet(int nums[], List<List<Integer>> res, List<Integer> subSet, int index){
        res.add(new ArrayList<>(subSet));
        
        for(int i=index;i<nums.length;i++){
            subSet.add(nums[i]);
            findPowetSet(nums,res,subSet,i+1);
            subSet.remove(subSet.size() - 1);
        }
    }
}
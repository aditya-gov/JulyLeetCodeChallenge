/*

Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]



*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length - 1;
        Arrays.sort(nums);
        for(int i=0;i<n-1;i++){
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int low = i + 1;
            int high = n;
            
            while(low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i],nums[low],nums[high]));
                    while(low < high && nums[low] == nums[low+1]){
                        low++;
                    }
                    while(low < high && nums[low] == nums[high-1]){
                        high--;
                    }
                    low++;
                    high--;
                }else if(sum > 0){
                    high--;
                }else{
                    low++;
                }
            }
        }
        return res;
    }
}
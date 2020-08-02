/*

Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

Example:

Input:  [1,2,1,3,2,5]
Output: [3,5]

Note:

    The order of the result is not important. So in the above example, [5, 3] is also correct.
    Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?


*/


class Solution {
    public int[] singleNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0) + 1);
        }
        for(Map.Entry<Integer,Integer> en : hm.entrySet()){
            if(en.getValue() < 2){
                list.add(en.getKey());
            }
        }
        int[] result = list.stream().mapToInt(i -> i).toArray();
        return result;
    }
}
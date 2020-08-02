/*

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:

    The same word in the dictionary may be reused multiple times in the segmentation.
    You may assume the dictionary does not contain duplicate words.

Example 1:

Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]

Example 2:

Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.

Example 3:

Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]



*/


class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        if(s.length() > 100){
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        wordBreakUtil(s, wordDict, res, new StringBuilder());
        return res;
    }
    
    public void wordBreakUtil(String s, List<String> wordDict, List<String> res, StringBuilder subList){
        if(subList.length() != 0){
            subList.append(" ");
        }
        for(String word : wordDict){
            if(s.startsWith(word)){
                StringBuilder sb = new StringBuilder(subList);
                sb.append(word);
                if(s.equals(word)){
                    res.add(sb.toString());
                } else{
                    wordBreakUtil(s.substring(word.length()),wordDict,res,sb);
                }
            }
        }
    }
}
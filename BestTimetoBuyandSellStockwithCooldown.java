/*

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

    You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
    After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)

Example:

Input: [1,2,3,0,2]
Output: 3 
Explanation: transactions = [buy, sell, cooldown, buy, sell]


*/

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length - 1;
        if(n <= 0){
            return 0;
        }
        int[] c = new int[n+1];
        int[] s = new int[n+1];
        c[0] = 0; c[1] = 0;
        s[1] = prices[1] - prices[0];
        
        for(int i=2;i<=n;i++){
            c[i] = Math.max(s[i-1],c[i-1]);
            s[i] = prices[i] - prices[i-1] + Math.max(c[i-2],s[i-1]);
        }
        return Math.max(c[n],s[n]);
    }
}	
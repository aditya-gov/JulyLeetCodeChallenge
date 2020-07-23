/*

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.

 

Constraints:

    board and word consists only of lowercase and uppercase English letters.
    1 <= board.length <= 200
    1 <= board[i].length <= 200
    1 <= word.length <= 10^3



*/


class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean visited[][] = new boolean[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(exist(board, i, j, word, 0, visited)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean exist(char[][] board, int i, int j, String word, int from, boolean visited[][]){
        if(from == word.length()){
            return true;
        }
        if(i < 0 || i >= board.length){
            return false;
        }
        if(j < 0 || j >= board[0].length){
            return false;
        }
        if(board[i][j] != word.charAt(from)){
            return false;
        }
        if(visited[i][j]){
            return false;
        }
        
        visited[i][j] = true;
        
        boolean res = exist(board, i + 1, j, word, from + 1, visited) ||
                        exist(board, i - 1, j, word, from + 1, visited) ||
                        exist(board, i, j + 1, word, from + 1, visited) ||
                        exist(board, i, j - 1, word, from + 1, visited);
        
        visited[i][j] = false;
        return res;
    }
}
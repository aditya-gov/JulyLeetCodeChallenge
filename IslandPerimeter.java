/*

You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

 

Example:

Input:
[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Output: 16

Explanation: The perimeter is the 16 yellow stripes in the image below:




*/

class Solution {
    int res = 0;
    
    public int islandPerimeter(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    dfs(i,j,grid);
                    return res;
                }
            }
        }
        return -1;
    }
    
    public void dfs(int x, int y, int grid[][]){
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0){
            res++;
            return;
        }
        if(grid[x][y] == -1){
            return;
        }
        grid[x][y] = -1;
        dfs(x+1,y,grid);
        dfs(x,y+1,grid);
        dfs(x-1,y,grid);
        dfs(x,y-1,grid);
    }
}
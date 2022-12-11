
//Solution -2

public class NumberOfIsland {
    public static void main(String[] args) {
    char[][] grid = {{'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}};


    int result = NumberOfIsland.numIslands(grid);
    System.out.println("Number of Island = " +result);

    }
    public static int numIslands(char[][] grid) {
            if(grid==null || grid.length ==0)return 0;
            int numberOfRow = grid.length;
            int numberOfColumn = grid[0].length;
            int num_islands =0;

            for(int r =0;r<numberOfRow;r++){
                for(int c=0;c<numberOfColumn;c++){
                    if(grid[r][c]=='1'){
                        num_islands++;
                        depthFirstSearch(grid,r,c);
                    }
                }
            }
            return num_islands;
        }
     public static void depthFirstSearch(char[][]grid ,int r,int c){
            int nr = grid.length;
            int nc = grid[0].length;
            if(r<0 || c<0 ||r>=nr ||c>=nc ||grid[r][c]=='0')return;
            grid[r][c]='0';
         depthFirstSearch(grid,r+1,c);
         depthFirstSearch(grid,r-1,c);
         depthFirstSearch(grid,r,c+1);
         depthFirstSearch(grid,r,c-1);
        }
    }


//Complexity Analysis

//Time complexity : O(M \times N)O(M×N) where MM is the number of rows and NN is the number of columns
//Space complexity : worst case O(M \times N)O(M×N) in case that the grid map is filled with lands where DFS goes by M \times NM×N deep.


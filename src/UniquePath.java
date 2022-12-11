public class UniquePath {
    public static void main(String[] args) {
            UniquePath uniquePath = new UniquePath();

            int [][] input1 = {{0,0,0},{0,1,0},{0,0,0}};
            int output1 = uniquePath.uniquePathsWithObstacles(input1);
            System.out.println("output1 = "+output1);

            int [][] input2 = {{0,1},{0,0}};
            int output2 = uniquePath.uniquePathsWithObstacles(input2);
            System.out.println("output2 = "+output2);

        }
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            if(obstacleGrid==null||obstacleGrid.length==0)
                return 0;

            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;

            if(obstacleGrid[0][0]==1||obstacleGrid[m-1][n-1]==1)
                return 0;

            int[][] dp = new int[m][n];
            dp[0][0]=1;

            for(int i=1; i<m; i++){
                if(obstacleGrid[i][0]==1){
                    dp[i][0] = 0;
                }else{
                    dp[i][0] = dp[i-1][0];
                }
            }

            for(int i=1; i<n; i++){
                if(obstacleGrid[0][i]==1){
                    dp[0][i] = 0;
                }else{
                    dp[0][i] = dp[0][i-1];
                }
            }

            for(int i=1; i<m; i++){
                for(int j=1; j<n; j++){
                    if(obstacleGrid[i][j]==1){
                        dp[i][j]=0;
                    }else{
                        dp[i][j]=dp[i-1][j]+dp[i][j-1];
                    }

                }
            }

            return dp[m-1][n-1];
        }
    }

//Time Complexity = O(m*n) where m and n is the size of matrix


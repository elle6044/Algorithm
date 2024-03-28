import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp=new int[triangle.length][];
        for(int i=0;i<triangle.length;i++){
            dp[i]=Arrays.copyOf(triangle[i],triangle[i].length);
        }
        
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                if(j==0){
                    dp[i][j]+=dp[i-1][j];
                }
                else if(j==dp[i].length-1){
                    dp[i][j]+=dp[i-1][dp[i-1].length-1];
                }
                else{
                    dp[i][j]+=Math.max(dp[i-1][j-1],dp[i-1][j]);
                }
            }
        }
        for(int i=0;i<dp[dp.length-1].length;i++){
            answer=Math.max(answer,dp[dp.length-1][i]);
        }
        return answer;
    }
}
import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        while(n>=1){
            if(n%2==0){
                n/=2;
            }
            else{
                n--;
                ans++;
            }
        }
        
        // int[] dp=new int[n+1];
        // for(int i=1;i<=n;i++){
        //     dp[i]=i;
        // }
        // for(int i=2;i<=n;i++){
        //     if(i%2==0){
        //         dp[i]=Math.min(dp[i-1]+1,dp[i/2]);
        //     }
        //     else{
        //         dp[i]=Math.min(dp[i-1]+1,dp[i/2]+1);
        //     }
        // }

        // ans=dp[n];
        return ans;
    }
    
    
}
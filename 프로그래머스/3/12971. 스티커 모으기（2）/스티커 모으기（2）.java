import java.util.*;
class Solution {
    public int solution(int sticker[]) {
        int answer = 0;

        if(sticker.length==1){
            answer=sticker[0];
        }
        else if(sticker.length==2){
            answer=Math.max(sticker[0],sticker[1]);
        }
        else if(sticker.length==3){
            answer=Math.max(sticker[0]+sticker[2],sticker[1]);
        }
        else{
            int[] dp1=new int[sticker.length];
            dp1[0]=sticker[0];
            dp1[1]=sticker[0];
            dp1[2]=sticker[0]+sticker[2];
            int[] dp2=new int[sticker.length];
            dp2[1]=sticker[1];
            dp2[2]=Math.max(sticker[1],sticker[2]);
            for(int i=3;i<sticker.length-1;i++){
                dp1[i]=Math.max(dp1[i-1],
                                Math.max(dp1[i-2]+sticker[i],dp1[i-3]+sticker[i]));
            }
            for(int i=3;i<sticker.length;i++){
                dp2[i]=Math.max(dp2[i-1],
                                Math.max(dp2[i-2]+sticker[i],dp2[i-3]+sticker[i]));
            }
            
            // System.out.println(Arrays.toString(dp1));
            // System.out.println(Arrays.toString(dp2));
            answer=Math.max(dp1[sticker.length-2],dp2[sticker.length-1]);
        }

        return answer;
    }
}
import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum=brown+yellow;
        for(int i=1;i<=Math.sqrt(sum);i++){
            if(sum%i==0){
                int a=i;
                int b=sum/i;
                if(2*a+2*b-4==brown){
                    answer[0]=b;
                    answer[1]=a;
                }
            }
            
        }
        return answer;
    }
}
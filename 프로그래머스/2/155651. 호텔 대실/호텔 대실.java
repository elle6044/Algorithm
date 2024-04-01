import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[] v=new int[2410];
        for(int i=0;i<book_time.length;i++){
            String[] input=book_time[i];
            int start=Integer.parseInt(input[0].replace(":",""));
            
            int endT=Integer.parseInt(input[1].substring(0,2));
            int endM=Integer.parseInt(input[1].substring(3));
            if(endT!=23&&endM+10>=60){
                endM-=60;
                endT++;
            }
            
            int end=endT*100+endM;
            for(int j=start;j<(end+10);j++){
                v[j]++;
            }
        }
        for(int i=0;i<2400;i++){
            answer=Math.max(answer,v[i]);
        }
        return answer;
    }
}
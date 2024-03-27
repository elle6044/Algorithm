import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left+1L)];
        
        long startI=left/n;
        long startJ=left%n;
        int cnt=0;
        for(int i=0;i<(int)(right-left+1);i++){
            answer[i]=(int)Math.max(startI+1,startJ+1);
            startJ++;
            if(startJ==n){
                startI++;
                startJ=0;
            }
        }

        return answer;
    }
}
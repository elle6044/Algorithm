import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int oneCnt=Integer.bitCount(n);
        while(true){
            if(oneCnt==Integer.bitCount(++n)){
                answer=n;
                break;
            }
        }
        
        return answer;
    }
}
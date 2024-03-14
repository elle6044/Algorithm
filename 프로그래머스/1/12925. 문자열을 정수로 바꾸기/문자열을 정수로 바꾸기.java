import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        if(s.charAt(0)<45){
            answer=Integer.parseInt(s.substring(1));
            answer*=s.charAt(0)=='+'?1:-1;
        }
        else{
            answer=Integer.parseInt(s);
        }
        return answer;
    }
}
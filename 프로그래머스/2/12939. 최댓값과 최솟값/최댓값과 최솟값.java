import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        StringTokenizer st=new StringTokenizer(s);
        int max=Integer.parseInt(st.nextToken());
        int min=max;
        while(st.hasMoreTokens()){
            int num=Integer.parseInt(st.nextToken());
            max=Math.max(max,num);
            min=Math.min(min,num);
        }
        answer=min+" "+max;
        return answer;
    }
}
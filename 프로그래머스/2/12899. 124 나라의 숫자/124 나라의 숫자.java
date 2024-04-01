import java.util.*;
class Solution {
    public String solution(int n) {
        String answer = "";
        Stack<Integer> s=new Stack();
        while(true){
            if(n%3==0){
                s.push(4);
                n-=3;
            }
            else{
                s.push(n%3);
                n-=n%3;
            }
            if(n==0) break;
            n/=3;
            
        }
        int size=s.size();
        for(int i=0;i<size;i++){
            answer+=s.pop();
        }
        return answer;
    }
}
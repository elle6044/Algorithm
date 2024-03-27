import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        Stack<Integer> s=new Stack();
        for(int i=0;i<number.length();i++){
            int num=number.charAt(i)-48;
            if(s.isEmpty()){
                s.push(num);
            }
            else{
                while(!s.isEmpty()&&k>0&&s.peek()<num){
                    s.pop();
                    k--;
                }
                s.push(num);
            }
        }
        int size=s.size();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<size;i++){
            if(k>0){
                s.pop();
                k--;
            }
            else{
                sb.append(s.pop());
            }
        }
        answer=sb.reverse().toString();
        return answer;
    }
}
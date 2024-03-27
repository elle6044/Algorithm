import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack=new Stack();
        int len=s.length();
        L:for(int i=0;i<len;i++){
            stack=new Stack();
            int cnt=0;
            for(int j=0;j<len;j++){
                char input=s.charAt((i+j)%len);
                if(input=='('||input=='{'||input=='['){
                    stack.push(input);
                }
                else{
                    if(stack.isEmpty()){
                        continue L;
                    }
                    else{
                        char output=stack.pop();
                        if((output=='('&&input==')')||
                          (output=='{'&&input=='}')||
                          (output=='['&&input==']')){
                            if(stack.isEmpty()){
                                // cnt++;
                            }
                        }
                        else{
                            continue L;
                        }
                    }
                }
            }
            if(stack.isEmpty()){
                answer++;
            }
        }
        return answer;
    }
}
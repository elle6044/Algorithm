import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        Stack<Character> stack=new Stack();
        for(int i=0;i<s.length();i++){
            char a=s.charAt(i);
            if(stack.isEmpty()){
                stack.push(a);
            }
            else{
                if(stack.peek()==a){
                    stack.pop();
                }
                else{
                    stack.push(a);
                }
            }
        }
        answer=stack.isEmpty()?1:0;

        return answer;
    }
}
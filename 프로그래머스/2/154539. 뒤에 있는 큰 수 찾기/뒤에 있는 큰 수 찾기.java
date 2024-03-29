import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer>stackIdx=new Stack();
        Stack<Integer>stackNum=new Stack();
        for(int i=0;i<numbers.length;i++){
            int number=numbers[i];
            while(!stackNum.isEmpty()&&stackNum.peek()<number){
                answer[stackIdx.pop()]=number;
                stackNum.pop();
            }
            stackIdx.push(i);
            stackNum.push(number);
        }
        if(!stackIdx.isEmpty()){
            for(int idx:stackIdx){
                answer[idx]=-1;
            }
        }
        
        return answer;
    }
}
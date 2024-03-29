import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stackIdx=new Stack();
        Stack<Integer> stackNum=new Stack();
        for(int i=0;i<prices.length;i++){
            int number=prices[i];
            while(!stackNum.isEmpty()&&stackNum.peek()>number){
                int idx=stackIdx.pop();
                answer[idx]=i-idx;
                stackNum.pop();
            }
            stackIdx.push(i);
            stackNum.push(number);
        }
        while(!stackIdx.isEmpty()){
            int idx=stackIdx.pop();
            answer[idx]=prices.length-1-idx;
        }
        return answer;
    }
}
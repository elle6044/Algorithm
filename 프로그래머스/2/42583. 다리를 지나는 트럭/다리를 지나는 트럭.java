import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = bridge_length;
        Queue<Integer>q=new ArrayDeque();
        int sum=0;
        int idx=0;
        while(idx<truck_weights.length){
            int input=truck_weights[idx];
            if(weight-sum>=input){
                q.offer(input);
                sum+=input;
                idx++;
            }
            else{
                q.offer(0);
            }
            if(q.size()==bridge_length){
                sum-=q.poll();
            }
            
            answer++;
        }
        return answer;
    }
}
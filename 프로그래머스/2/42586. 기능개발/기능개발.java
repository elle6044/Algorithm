import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> q=new ArrayDeque();
        int temp=(100-progresses[0])%speeds[0]==0?
            (100-progresses[0])/speeds[0]:(100-progresses[0])/speeds[0]+1;
        int cnt=1;
        for(int i=1;i<progresses.length;i++){
            int day=(100-progresses[i])%speeds[i]==0?
                (100-progresses[i])/speeds[i]:(100-progresses[i])/speeds[i]+1;
            if(temp>=day){
                cnt++;
            }
            else{
                q.add(cnt);
                cnt=1;
                temp=day;
            }
        }
        q.add(cnt);
        answer=new int[q.size()];
        for(int i=0;i<answer.length;i++){
            answer[i]=q.poll();
        }
        return answer;
    }
}
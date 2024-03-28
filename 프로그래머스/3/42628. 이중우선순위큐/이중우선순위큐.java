import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0,0};
        PriorityQueue<Integer>pq1=new PriorityQueue();
        PriorityQueue<Integer>pq2=new PriorityQueue(Comparator.reverseOrder());
        int cnt=0;
        for(String input:operations){
            if(input.equals("D 1")){
                if(!pq2.isEmpty()){
                    pq1.remove(pq2.poll());
                    cnt--;
                }
            }
            else if(input.equals("D -1")){
                if(!pq1.isEmpty()){
                    pq2.remove(pq1.poll());
                    cnt--;
                }
            }
            else{
                int num=Integer.parseInt(input.substring(2));
                pq1.offer(num);
                pq2.offer(num);
                cnt++;
            }
        }
        if(pq1.size()!=0){
            answer[0]=pq2.poll();
            answer[1]=pq1.poll();
        }
        
        return answer;
    }
}
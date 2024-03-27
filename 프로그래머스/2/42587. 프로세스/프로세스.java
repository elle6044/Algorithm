import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Point>q=new ArrayDeque();
        for(int i=0;i<priorities.length;i++){
            q.offer(new Point(i,priorities[i]));
        }
        int cnt=1;
        L:while(true){
            Point p=q.poll();
            for(Point np:q){
                if(p.power<np.power){
                    q.offer(p);
                    continue L;
                }
            }
            if(p.idx==location){
                answer=cnt;
                break;
            }
            cnt++;
        }
        return answer;
    }
    static class Point{
        int idx,power;
        public Point(int idx, int power){
            this.idx=idx;
            this.power=power;
        }
    }
}
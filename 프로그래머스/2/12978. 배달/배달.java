import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        ArrayList<Point>[] arrays=new ArrayList[N];
        for(int i=0;i<N;i++){
            arrays[i]=new ArrayList();
        }
        for(int i=0;i<road.length;i++){
            int s=road[i][0]-1;
            int e=road[i][1]-1;
            int w=road[i][2];
            arrays[s].add(new Point(e,w));
            arrays[e].add(new Point(s,w));
        }
        
        PriorityQueue<Point>pq=new PriorityQueue();
        int dist[]=new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0]=0;
        pq.offer(new Point(0,0));
        while(!pq.isEmpty()){
            Point p=pq.poll();
            if(dist[p.e]<p.w) continue;
            for(Point np:arrays[p.e]){
                int nw=dist[p.e]+np.w;
                if(nw<dist[np.e]){
                    dist[np.e]=nw;
                    pq.add(new Point(np.e,nw));
                }
            }
        }
        
        for(int i=0;i<N;i++){
            if(dist[i]<=K){
                answer++;
            }
        }
        
        return answer;
    }
    
    static class Point implements Comparable<Point>{
        int e,w;
        public Point(int e, int w){
            this.e=e;
            this.w=w;
        }
        
        @Override
        public int compareTo(Point o){
            return this.w-o.w;
        }
    }
}
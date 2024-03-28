import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        map=computers;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(computers[i][j]==1){
                    bfs(i,j);
                    answer++;
                }
            }
        }
        return answer;
    }
    
    static int[][]map;
    public void bfs(int i, int j){
        Queue<Point> q=new ArrayDeque();
        q.offer(new Point(i,j));
        map[i][j]=0;
        while(!q.isEmpty()){
            Point p=q.poll();
            for(int d=0;d<map.length;d++){
                if(map[d][p.c]==1){
                    q.offer(new Point(d,p.c));
                    map[d][p.c]=0;
                }
                if(map[p.r][d]==1){
                    q.offer(new Point(p.r,d));
                    map[p.r][d]=0;
                }
            }
        }
    }
    
    static int[] dr={1,-1,0,0};
    static int[] dc={0,0,1,-1};
    static class Point{
        int r,c;
        public Point(int r, int c){
            this.r=r;
            this.c=c;
        }
    }
}
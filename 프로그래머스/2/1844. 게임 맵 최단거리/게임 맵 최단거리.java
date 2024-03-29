import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        N=maps.length;
        M=maps[0].length;
        map=maps;
        v=new boolean[N][M];
        if(map[0][0]==1){
            v[0][0]=true;
            bfs();
            answer=min==Integer.MAX_VALUE?-1:min;
        }
        return answer;
    }
    static int min=Integer.MAX_VALUE;
    public void bfs(){
        Queue<Point>q=new ArrayDeque();
        q.offer(new Point(0,0,1));
        v[0][0]=true;
        while(!q.isEmpty()){
            Point p=q.poll();
            if(p.r==N-1&&p.c==M-1){
                min=Math.min(min,p.cnt);
            }
            for(int d=0;d<4;d++){
                int nr=p.r+dr[d];
                int nc=p.c+dc[d];
                if(nr>=0&&nr<N&&nc>=0&&nc<M&&map[nr][nc]==1&&!v[nr][nc]){
                    q.offer(new Point(nr,nc,p.cnt+1));
                    v[nr][nc]=true;
                }
            }
        }
    }
    static int N,M;
    static int[][]map;
    static boolean[][]v;
    static int[]dr={1,-1,0,0};
    static int[]dc={0,0,1,-1};
    static class Point{
        int r,c,cnt;
        public Point(int r, int c, int cnt){
            this.r=r;
            this.c=c;
            this.cnt=cnt;
        }
    }
}
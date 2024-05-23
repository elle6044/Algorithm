import java.util.*;
import java.io.*;

class Solution {
    static int N,M;
    static char[][] map;
    static boolean[][] v;
    public int solution(String[] board) {
        
        N=board.length;
        M=board[0].length();
        map=new char[N][M];
        
        int sr=0;
        int sc=0;
        for(int i=0;i<N;i++){
            String input=board[i];
            for(int j=0;j<M;j++){
                char a=input.charAt(j);
                map[i][j]=a;
                if(a=='R'){
                    sr=i;
                    sc=j;
                }
            }
        }
        
        bfs(sr,sc);
        if(answer==Integer.MAX_VALUE){
            answer=-1;
        }
        return answer;
    }
    
    static int answer=Integer.MAX_VALUE;
    
    static void bfs(int r, int c){
        v=new boolean[N][M];
        Queue<Point> q=new ArrayDeque();
        q.offer(new Point(r,c,0));
        v[r][c]=true;
        while(!q.isEmpty()){
            Point p=q.poll();
            if(map[p.r][p.c]=='G'){
                answer=p.cnt;
                return;
            }
            for(int d=0;d<4;d++){
                int nr=p.r;
                int nc=p.c;
                while(nr>=0&&nr<N&&nc>=0&&nc<M&&map[nr][nc]!='D'){
                    nr+=dr[d];
                    nc+=dc[d];
                }
                if(nr!=r||nc!=c){
                    nr-=dr[d];
                    nc-=dc[d];
                }
                if(!v[nr][nc]){
                    v[nr][nc]=true;
                    q.offer(new Point(nr,nc,p.cnt+1));
                }
            }
        }
    }
    static class Point{
        int r,c,cnt;
        public Point(int r, int c, int cnt){
            this.r=r;
            this.c=c;
            this.cnt=cnt;
        }
    }
    
    static int[] dr={1,-1,0,0};
    static int[] dc={0,0,1,-1};
}
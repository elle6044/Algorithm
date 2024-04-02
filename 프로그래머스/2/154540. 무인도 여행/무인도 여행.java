import java.util.*;
class Solution {
    public int[] solution(String[] maps) {
        int[] answer = {};
        N=maps.length;
        M=maps[0].length();
        map=maps;
        v=new boolean[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i].charAt(j)!='X'&&!v[i][j]){
                    bfs(i,j);
                }
            }
        }
        int size=pq.size();
        if(size==0){
            answer=new int[1];
            answer[0]=-1;
        }
        else{
            answer=new int[size];
            for(int i=0;i<size;i++){
                answer[i]=pq.poll();
            }
        }
        return answer;
    }
    static PriorityQueue<Integer>pq=new PriorityQueue();
    public void bfs(int r,int c){
        Queue<Point>q=new ArrayDeque();
        int sum=map[r].charAt(c)-48;
        q.offer(new Point(r,c));
        v[r][c]=true;
        while(!q.isEmpty()){
            Point p=q.poll();
            for(int d=0;d<4;d++){
                int nr=p.r+dr[d];
                int nc=p.c+dc[d];
                if(nr>=0&&nr<N&&nc>=0&&nc<M&&map[nr].charAt(nc)!='X'&&!v[nr][nc]){
                    sum+=map[nr].charAt(nc)-48;
                    q.offer(new Point(nr,nc));
                    v[nr][nc]=true;
                }
            }
        }
        pq.offer(sum);
    }
    static int[] dr={1,-1,0,0};
    static int[] dc={0,0,1,-1};
    static class Point{
        int r,c;
        public Point(int r,int c){
            this.r=r;
            this.c=c;
        }
    }
    static int N,M;
    static String[] map;
    static boolean[][] v;
}
import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N;
    static int[][] map;
    static boolean[][] v;

    static int[] dr={1,-1,0,0};
    static int[] dc={0,0,1,-1};
    static class Point{
        int r,c,cnt;
        public Point(int r, int c, int cnt){
            this.r=r;
            this.c=c;
            this.cnt=cnt;
        }
    }

    static Queue<Point> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        N=Integer.parseInt(br.readLine());
        map=new int[N][N];
        v=new boolean[N][N];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int landCnt=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]!=0&&!v[i][j]){
                    landCnt++;
                    bfs(i,j,landCnt);
                }
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]!=0){
                    v=new boolean[N][N];
                    bfs2(i,j,map[i][j]);
                }

            }
        }

        bw.write(minCnt+"");
        bw.close();
    }


    static int minCnt=Integer.MAX_VALUE;
    private static void bfs2(int i, int j, int landNum) {
        q.offer(new Point(i,j,0));
        v[i][j]=true;
        while(!q.isEmpty()){
            Point p=q.poll();
            for(int d=0;d<4;d++){
                int nr=p.r+dr[d];
                int nc=p.c+dc[d];
                if(nr>=0&&nr<N&&nc>=0&&nc<N&&!v[nr][nc]&&map[nr][nc]!=landNum){
                    if(map[nr][nc]==0){
                        q.offer(new Point(nr,nc,p.cnt+1));
                        v[nr][nc]=true;
                    }
                    else{
                        minCnt=Math.min(minCnt,p.cnt);
                    }
                }
            }
        }
    }

    private static void bfs(int r, int c, int landCnt) {
        q.offer(new Point(r,c,0));
        v[r][c]=true;
        map[r][c]=landCnt;
        while(!q.isEmpty()){
            Point p = q.poll();
            for(int d=0;d<4;d++){
                int nr=p.r+dr[d];
                int nc=p.c+dc[d];
                if(nr>=0&&nr<N&&nc>=0&&nc<N&&!v[nr][nc]&&map[nr][nc]==1){
                    q.offer(new Point(nr,nc,0));
                    v[nr][nc]=true;
                    map[nr][nc]=landCnt;
                }
            }
        }
    }
}

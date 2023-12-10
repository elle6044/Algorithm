import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N,M,T;
    static int[][] map;
    static boolean[][][] v;
    static int[] dr={1,-1,0,0};
    static int[] dc={0,0,1,-1};
    static class Point{
        int r,c,cnt,item;
        public Point(int r,int c,int cnt,int item){
            this.r=r;
            this.c=c;
            this.cnt=cnt;
            this.item=item;
        }
    }

    static Queue<Point> q=new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        T=Integer.parseInt(st.nextToken());

        map=new int[N][M];
        v=new boolean[2][N][M];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        if(minCnt==Integer.MAX_VALUE){
            bw.write("Fail");
        }
        else{
            bw.write(minCnt+"");
        }

        bw.close();
    }

    static int minCnt=Integer.MAX_VALUE;
    private static void bfs() {
        if(map[0][0]==0){
            q.offer(new Point(0,0,0,0));
            v[0][0][0]=true;
        }
        else{
            q.offer(new Point(0,0,0,1));
            v[1][0][0]=true;
        }

        while(!q.isEmpty()){
            Point p=q.poll();
            if(p.r==N-1&&p.c==M-1&&p.cnt<minCnt&&p.cnt<=T){
                minCnt=p.cnt;
            }
            if(p.cnt>T) return;

            for(int d=0;d<4;d++){
                int nr=p.r+dr[d];
                int nc=p.c+dc[d];
                if(nr>=0&&nr<N&&nc>=0&&nc<M&&!v[p.item][nr][nc]){
                    if(p.item==0){
                        if(map[nr][nc]==0){
                            q.offer(new Point(nr,nc,p.cnt+1,0));
                            v[0][nr][nc]=true;
                        }
                        else if(map[nr][nc]==2){
                            q.offer(new Point(nr,nc,p.cnt+1,1));
                            v[1][nr][nc]=true;
                        }
                    }
                    else{
                        q.offer(new Point(nr,nc,p.cnt+1,1));
                        v[1][nr][nc]=true;
                    }
                }
            }
        }
    }
}

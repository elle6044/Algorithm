import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int T,N,M;
    static char[][] map;
    static boolean[][] v;

    static int[] dr={1,-1,0,0};
    static int[] dc={0,0,1,-1};
    static class Point{
        int r,c,cnt;
        char type;
        public Point(int r, int c, int cnt, char type){
            this.r=r;
            this.c=c;
            this.cnt=cnt;
            this.type=type;
        }
    }
    static Queue<Point> q=new ArrayDeque<>();
    static int minCnt=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        T=Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            st=new StringTokenizer(br.readLine());
            M=Integer.parseInt(st.nextToken());
            N=Integer.parseInt(st.nextToken());
            map=new char[N][M];
            v=new boolean[N][M];
            minCnt=Integer.MAX_VALUE;

            int sr=0;
            int sc=0;
            for(int i=0;i<N;i++){
                String input=br.readLine();
                for(int j=0;j<M;j++){
                    char in=input.charAt(j);
                    map[i][j]=in;
                    if(in=='*'){
                        v[i][j]=true;
                        q.offer(new Point(i,j,0,'*'));
                    }
                    else if(in=='@'){
                        sr=i;
                        sc=j;
                    }
                }
            }
            q.offer(new Point(sr,sc,0,'@'));

            bfs();

            if(minCnt==Integer.MAX_VALUE){
                bw.write("IMPOSSIBLE");
            }
            else{
                bw.write(minCnt+"");
            }
            if(t!=T-1){
                bw.write("\n");
            }
        }
        bw.close();
    }

    private static void bfs() {
        while(!q.isEmpty()){
            Point p=q.poll();
            if((p.r==0||p.r==N-1||p.c==0||p.c==M-1)&&p.type=='@'&&p.cnt<minCnt){
                minCnt=p.cnt+1;
            }

            for(int d=0;d<4;d++){
                int nr=p.r+dr[d];
                int nc=p.c+dc[d];
                if(nr>=0&&nr<N&&nc>=0&&nc<M&&!v[nr][nc]&&map[nr][nc]=='.'){
                    if(p.type=='*'){
                        v[nr][nc]=true;
                        q.offer(new Point(nr,nc,p.cnt+1,'*'));
                    }
                    else{
                        v[nr][nc]=true;
                        q.offer(new Point(nr,nc,p.cnt+1,'@'));
                    }
                }
            }
        }
    }
}

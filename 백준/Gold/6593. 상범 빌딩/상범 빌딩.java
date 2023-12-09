import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int H,N,M;
    static char[][][] map;
    static boolean[][][] v;

    static int[] dh={1,-1};
    static int[] dr={1,-1,0,0};
    static int[] dc={0,0,1,-1};
    static class Point{
        int h,r,c,cnt;
        public Point(int h,int r,int c,int cnt){
            this.h=h;
            this.r=r;
            this.c=c;
            this.cnt=cnt;
        }
    }

    static int sh;
    static int sr;
    static int sc;
    static int eh;
    static int er;
    static int ec;

    public static void main(String[] args) throws IOException {
        while(true){
            st=new StringTokenizer(br.readLine());
            H=Integer.parseInt(st.nextToken());
            N=Integer.parseInt(st.nextToken());
            M=Integer.parseInt(st.nextToken());
            if(H==0)break;

            map=new char[H][N][M];
            v=new boolean[H][N][M];

            for(int h=0;h<H;h++){
                for(int i=0;i<N;i++){
                    String word=br.readLine();
                    for(int j=0;j<M;j++){
                        char input=word.charAt(j);
                        map[h][i][j]=input;
                        if(input=='S'){
                            sh=h;
                            sr=i;
                            sc=j;
                        }
                        else if(input=='E'){
                            eh=h;
                            er=i;
                            ec=j;
                        }
                    }
                }
                br.readLine();
            }

            bfs(sh,sr,sc);

            if(minCnt==Integer.MAX_VALUE){
                bw.write("Trapped!");
            }
            else{
                bw.write("Escaped in "+minCnt+" minute(s).");
            }

            bw.write("\n");
            minCnt=Integer.MAX_VALUE;
        }
        bw.close();

    }

    static Queue<Point> q=new ArrayDeque<>();
    static int minCnt=Integer.MAX_VALUE;
    private static void bfs(int sh, int sr, int sc) {
        q.offer(new Point(sh,sr,sc,0));
        v[sh][sr][sc]=true;

        while(!q.isEmpty()){
            Point p = q.poll();
            if(p.h==eh&&p.r==er&&p.c==ec&&p.cnt<minCnt){
                minCnt=p.cnt;
            }

            for(int d=0;d<4;d++){
                int nr=p.r+dr[d];
                int nc=p.c+dc[d];
                if(nr>=0&&nr<N&&nc>=0&&nc<M&&!v[p.h][nr][nc]&&map[p.h][nr][nc]!='#'){
                    q.offer(new Point(p.h,nr,nc,p.cnt+1));
                    v[p.h][nr][nc]=true;
                }
            }

            for(int d=0;d<2;d++){
                int nh=p.h+dh[d];
                if(nh>=0&&nh<H&&!v[nh][p.r][p.c]&&map[nh][p.r][p.c]!='#'){
                    q.offer(new Point(nh,p.r,p.c,p.cnt+1));
                    v[nh][p.r][p.c]=true;
                }
            }
        }
    }
}

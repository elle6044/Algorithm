import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N,M;
    static int[][] map;
    static boolean[][][] v;

    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        map=new int[N][M];
        v=new boolean[2][N][M];

        for(int i=0;i<N;i++){
            String word=br.readLine();
            for(int j=0;j<M;j++){
                map[i][j]=Character.getNumericValue(word.charAt(j));
            }
        }

        bfs();
        if(minCnt==Integer.MAX_VALUE) minCnt=-1;
        bw.write(minCnt+"");
        bw.close();
    }

    static class Point{
        int h,r,c,cnt;
        public Point(int h, int r, int c, int cnt){
            this.h=h;
            this.r=r;
            this.c=c;
            this.cnt=cnt;
        }
    }

    static int[] dr={1,-1,0,0};
    static int[] dc={0,0,1,-1};

    static int minCnt = Integer.MAX_VALUE;
    private static void bfs() {
        Queue<Point> q = new ArrayDeque<>();
        v[0][0][0]=true;
        q.offer(new Point(0,0,0,1));
        while(!q.isEmpty()){
            Point p=q.poll();
            if(p.r==N-1&&p.c==M-1&&p.cnt<minCnt){
                minCnt=p.cnt;
            }
            for(int d=0;d<4;d++){
                int nr = p.r+dr[d];
                int nc = p.c+dc[d];
                if(nr>=0&&nr<N&&nc>=0&&nc<M){
                    if(map[nr][nc]==0){
                        if(!v[p.h][nr][nc]){
                            v[p.h][nr][nc]=true;
                            q.offer(new Point(p.h,nr,nc,p.cnt+1));
                        }
                    }
                    else{
                        if(p.h==0){
                            if(!v[p.h+1][nr][nc]){
                                v[p.h+1][nr][nc]=true;
                                q.offer(new Point(p.h+1,nr,nc,p.cnt+1));
                            }
                        }
                    }
                }
            }
        }
    }
}

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N,M;
    static char[][] map;
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
    static int count=0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        map=new char[N][M];
        v=new boolean[N][M];
        for(int i=0;i<N;i++){
            String word=br.readLine();
            for(int j=0;j<M;j++){
                map[i][j]=word.charAt(j);
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]=='L'){
                    v=new boolean[N][M];
                    bfs(i,j);
                }
            }
        }

        bw.write(count+"");
        bw.close();
    }

    static Queue<Point> q = new ArrayDeque<>();
    private static void bfs(int i, int j) {
       q.offer(new Point(i,j,0));
       v[i][j]=true;
       while(!q.isEmpty()){
           Point p = q.poll();
           for(int d=0;d<4;d++){
               int nr=p.r+dr[d];
               int nc=p.c+dc[d];
               if(nr>=0&&nr<N&&nc>=0&&nc<M&&!v[nr][nc]&&map[nr][nc]=='L'){
                   q.offer(new Point(nr,nc,p.cnt+1));
                   v[nr][nc]=true;

                   count=Math.max(count,p.cnt+1);
               }
           }
       }
    }
}

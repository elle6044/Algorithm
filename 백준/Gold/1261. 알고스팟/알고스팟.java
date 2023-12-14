import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N,M;
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

    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        M=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());

        map=new int[N][M];
        v=new boolean[N][M];

        for(int i=0;i<N;i++){
            String word=br.readLine();
            for(int j=0;j<M;j++){
                map[i][j]=word.charAt(j)-'0';
            }
        }

        bw.write(bfs()+"");
        bw.close();
    }

    private static int bfs() {
        Deque<Point> q=new ArrayDeque<>();
        q.offer(new Point(0,0,0));
        while(!q.isEmpty()){
            Point p=q.poll();
            if(p.r==N-1&&p.c==M-1){
                return p.cnt;
            }

            for(int d=0;d<4;d++){
                int nr=p.r+dr[d];
                int nc=p.c+dc[d];
                if(nr>=0&&nr<N&&nc>=0&&nc<M&&!v[nr][nc]){
                    if(map[nr][nc]==0){
                        q.offerFirst(new Point(nr,nc,p.cnt));
                        v[nr][nc]=true;
                    }
                    else{
                        q.offerLast(new Point(nr,nc,p.cnt+1));
                        v[nr][nc]=true;
                    }
                }
            }
        }
        return -1;
    }
}

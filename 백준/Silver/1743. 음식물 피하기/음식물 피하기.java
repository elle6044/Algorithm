import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static int N,M,K;
    static boolean[][] map;


    public static void main(String[] args) throws Exception {
        N=nextInt();
        M=nextInt();
        K=nextInt();
        map=new boolean[N][M];
        for(int i=0;i<K;i++){
            map[nextInt()-1][nextInt()-1]=true;
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if (map[i][j]){
                    bfs(i,j);
                }
            }
        }

        bw.write(max+"");
        bw.close();
    }

    static class Point{
        int r,c;
        public Point(int r, int c){
            this.r=r;
            this.c=c;
        }
    }

    static int[] dr={1,-1,0,0};
    static int[] dc={0,0,1,-1};
    static int max=0;
    private static void bfs(int r, int c) {
        int size=1;
        Queue<Point> q=new ArrayDeque<>();
        q.offer(new Point(r,c));
        map[r][c]=false;
        while (!q.isEmpty()){
            Point p=q.poll();
            for(int d=0;d<4;d++){
                int nr=p.r+dr[d];
                int nc=p.c+dc[d];
                if(nr>=0&&nr<N&&nc>=0&&nc<M&&map[nr][nc]){
                    q.offer(new Point(nr,nc));
                    map[nr][nc]=false;
                    size++;
                }
            }
        }
        max=Math.max(max,size);
    }

    static int nextInt() throws Exception {
        int sign = 0;
        int n = 0;
        int c;
        while ((c = System.in.read()) <= 32);
        if(c == 45) {
            sign = 1;
            c = System.in.read();
        }
        do n = (n << 3) + (n << 1) + (c & 15);
        while ((c = System.in.read()) > 47 && c < 58);
        return sign == 0 ? n : ~n + 1;
    }

}

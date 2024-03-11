import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    static int N,M;
    static int[][] map;


    public static void main(String[] args) throws Exception {
        N=nextInt();
        M=nextInt();
        map=new int[N][M];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                map[i][j]=nextInt();
            }
        }

        int cnt=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]==1){
                    cnt++;
                    bfs(i,j);
                }
            }
        }

        bw.write(cnt+"\n"+max);
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
        int cnt=1;
        Queue<Point>q=new ArrayDeque<>();
        map[r][c]++;
        q.offer(new Point(r,c));
        while(!q.isEmpty()){
            Point p=q.poll();
            for(int d=0;d<4;d++){
                int nr=p.r+dr[d];
                int nc=p.c+dc[d];
                if(nr>=0&&nr<N&&nc>=0&&nc<M&&map[nr][nc]==1){
                    map[nr][nc]++;
                    q.offer(new Point(nr,nc));
                    cnt++;
                }
            }
        }
        max=Math.max(max,cnt);
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

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static int N,M;
    static int[][]map;
    static int[] dr={-1,0,1,0};
    static int[] dc={0,1,0,-1};
    static class Point{
        int r,c,d;
        public Point(int r, int c, int d){
            this.r=r;
            this.c=c;
            this.d=d;
        }
    }

    public static void main(String[] args) throws Exception {
        N=nextInt();
        M=nextInt();
        map=new int[N][M];
        int sr=nextInt();
        int sc=nextInt();
        int sd=nextInt();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                map[i][j]=nextInt();
            }
        }

        bfs(sr,sc,sd);

        bw.write(cnt+"");
        bw.close();
    }

    static int cnt=1;
    private static void bfs(int sr, int sc, int sd) {
        Queue<Point>q=new ArrayDeque<>();
        q.offer(new Point(sr,sc,sd));
        map[sr][sc]=-1;

        L:while(!q.isEmpty()){
            Point p=q.poll();

            for(int d=0;d<4;d++){
                int nd=p.d;
                for(int d1=0;d1<=d;d1++){
                    nd=nd==0?3:nd-1;
                }
                int nr=p.r+dr[nd];
                int nc=p.c+dc[nd];
                if(map[nr][nc]==0){
                    q.offer(new Point(nr,nc,nd));
                    map[nr][nc]=-1;
                    cnt++;
                    continue L;
                }
            }
            int bd=p.d<2?p.d+2:p.d-2;
            int br=p.r+dr[bd];
            int bc=p.c+dc[bd];
            if(map[br][bc]==-1){
                q.offer(new Point(br,bc,p.d));
            }
            else{
                return;
            }
        }
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

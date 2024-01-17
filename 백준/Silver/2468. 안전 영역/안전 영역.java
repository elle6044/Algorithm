import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int lowWater=Integer.MAX_VALUE;
    static int highWater=Integer.MIN_VALUE;
    static int[][]map;
    static boolean[][]v;

    public static void main(String[] args) throws Exception {
        N=nextInt();
        map=new int[N][N];
        v=new boolean[N][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                map[i][j]=nextInt();
                lowWater=Math.min(lowWater,map[i][j]);
                highWater=Math.max(highWater,map[i][j]);
            }
        }

        int maxCnt=1;

        while(lowWater<highWater){
            v=new boolean[N][N];
            int cnt=0;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(map[i][j]-lowWater>0&&!v[i][j]){
                        bfs(i,j);
                        cnt++;
                    }
                }
            }
            if(maxCnt<=cnt){
                maxCnt=cnt;
            }

            lowWater++;
        }

        bw.write(maxCnt+"");
        bw.close();
    }

    static int[] dr={1,-1,0,0};
    static int[] dc={0,0,1,-1};
    static class Point{
        int r,c;
        public Point(int r, int c){
            this.r=r;
            this.c=c;
        }
    }
    private static void bfs(int i, int j) {
        Queue<Point> q=new ArrayDeque<>();
        q.offer(new Point(i,j));
        v[i][j]=true;
        while(!q.isEmpty()){
            Point p=q.poll();
            for(int d=0;d<4;d++){
                int nr=p.r+dr[d];
                int nc=p.c+dc[d];
                if(nr>=0&&nr<N&&nc>=0&&nc<N&&!v[nr][nc]&&map[nr][nc]-lowWater>0){
                    q.offer(new Point(nr,nc));
                    v[nr][nc]=true;
                }
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

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N;
    static int[][] map,dist;

    static int[] dr={1,-1,0,0};
    static int[] dc={0,0,1,-1};
    static class Point implements Comparable<Point>{
        int r,c,w;
        public Point(int r, int c, int w){
            this.r=r;
            this.c=c;
            this.w=w;
        }
        @Override
        public int compareTo(Point o) {
            return this.w-o.w;
        }
    }

    public static void main(String[] args) throws IOException {
        int cnt=1;
        while(true){
            N=Integer.parseInt(br.readLine());
            if(N==0) break;

            map=new int[N][N];
            dist=new int[N][N];

            for(int i=0;i<N;i++){
                st=new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    map[i][j]=Integer.parseInt(st.nextToken());
                    dist[i][j]=Integer.MAX_VALUE;
                }
            }

            dijkstra();
            bw.write("Problem "+cnt+": "+dist[N-1][N-1]+"\n");
            cnt++;
        }
        bw.close();
    }

    private static void dijkstra() {
        PriorityQueue<Point> pq=new PriorityQueue<>();
        pq.offer(new Point(0,0,map[0][0]));
        dist[0][0]=map[0][0];

        while(!pq.isEmpty()){
            Point p=pq.poll();
            if(p.w>dist[p.r][p.c]) continue;

            for(int d=0;d<4;d++){
                int nr=p.r+dr[d];
                int nc=p.c+dc[d];
                if(nr>=0&&nr<N&&nc>=0&&nc<N){
                    int nw=dist[p.r][p.c]+map[nr][nc];
                    if(nw<dist[nr][nc]){
                        pq.offer(new Point(nr,nc,nw));
                        dist[nr][nc]=nw;
                    }
                }
            }
        }
    }
}

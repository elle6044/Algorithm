import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N,M;
    static int[][] map;
    static boolean[][] v;

    static int[] dr={-1,-1,-1,0,1,1,1,0};
    static int[] dc={-1,0,1,1,1,0,-1,-1};
    static class Point{
        int r,c,high;
        public Point(int r,int c,int high){
            this.r=r;
            this.c=c;
            this.high=high;
        }
    }

    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        map=new int[N][M];
        v=new boolean[N][M];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int cnt=0;
        while(true){
            int max=-1;
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(map[i][j]>max&&!v[i][j]){
                        max=map[i][j];
                    }
                }
            }
            if(max==-1) break;

            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(map[i][j]==max&&!v[i][j]){
                        bfs(i,j,max);
//                        System.out.println(i+" : "+j+" : "+max);
                        cnt++;
                    }
                }
            }
        }

        bw.write(cnt+"");
        bw.close();
    }

    private static void bfs(int i, int j, int max) {
        Queue<Point> q=new ArrayDeque<>();
        q.offer(new Point(i,j,max));
        v[i][j]=true;

        while(!q.isEmpty()){
            Point p=q.poll();

            for(int d=0;d<8;d++){
                int nr=p.r+dr[d];
                int nc=p.c+dc[d];
                if(nr>=0&&nr<N&&nc>=0&&nc<M&&!v[nr][nc]&&p.high>=map[nr][nc]){
                    q.offer(new Point(nr,nc,map[nr][nc]));
                    v[nr][nc]=true;
                }
            }
        }
    }
}

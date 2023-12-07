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
    static boolean[][] v;

    static int[] dr={1,-1,0,0};
    static int[] dc={0,0,1,-1};
    static class Point{
        int r,c;
        public Point(int r, int c){
            this.r=r;
            this.c=c;
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

        int roofCount=0;
        while(true){
            v=new boolean[N][M];
            int bfsResult=bfs();
            if(bfsResult==0) break;
            roofCount++;
        }

        bw.write(roofCount+"\n");
        bw.write(count+"");
        bw.close();
    }

    static int count=0;

    private static int bfs() {
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(0,0));
        v[0][0]=true;

        int nowCount=0;

        while(!q.isEmpty()){
            Point p=q.poll();
            for(int d=0;d<4;d++){
                int nr=p.r+dr[d];
                int nc=p.c+dc[d];
                if(nr>=0&&nr<N&&nc>=0&&nc<M&&!v[nr][nc]){
                    if(map[nr][nc]==0){
                        q.offer(new Point(nr,nc));
                        v[nr][nc]=true;
                    }
                    else{
                        map[nr][nc]=0;
                        v[nr][nc]=true;
                        nowCount++;
                    }
                }
            }
        }
        if(nowCount!=0){
            count=nowCount;
        }
        return nowCount;
    }
}

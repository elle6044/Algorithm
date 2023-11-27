import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int T;
    static int N,M,K;
    static int[][] map;


    static int count;

    public static void main(String[] args) throws IOException {
        T=Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++){
            st=new StringTokenizer(br.readLine());
            N=Integer.parseInt(st.nextToken());
            M=Integer.parseInt(st.nextToken());
            K=Integer.parseInt(st.nextToken());

            map=new int[N][M];
            count=0;

            for(int k=0;k<K;k++){
                st=new StringTokenizer(br.readLine());
                int x=Integer.parseInt(st.nextToken());
                int y=Integer.parseInt(st.nextToken());
                map[x][y]=1;
            }

            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(map[i][j]==1){
                        bfs(i,j);
                        count++;
                    }
                }
            }
            bw.write(count+"");
            if(t!=T) bw.write("\n");
        }
        bw.close();
    }


    static class Point{
        int r,c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[] dr={1,-1,0,0};
    static int[] dc={0,0,1,-1};

    public static void bfs(int r, int c){
        Queue<Point> queue = new LinkedList<>();
        map[r][c]=0;

        queue.offer(new Point(r,c));
        while(!queue.isEmpty()){
            Point p = queue.poll();

            for(int d=0;d<4;d++){
                int nr=p.r+dr[d];
                int nc=p.c+dc[d];
                if(nr>=0&&nr<N&&nc>=0&&nc<M&&map[nr][nc]==1){
                    map[nr][nc]=0;
                    queue.offer(new Point(nr,nc));
                }
            }
        }
    }
}

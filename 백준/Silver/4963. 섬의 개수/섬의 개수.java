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
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        while(true){
            st=new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            if(N==M&&N==0) break;

            map=new int[N][M];
            visit=new boolean[N][M];
            for(int i=0;i<N;i++){
                st=new StringTokenizer(br.readLine());
                for(int j=0;j<M;j++){
                    map[i][j]=Integer.parseInt(st.nextToken());
                }
            }

            int count=0;
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(map[i][j]==1&&!visit[i][j]){
                        bfs(i,j);
                        count++;
                    }
                }
            }

            bw.write(count+"\n");
        }
        bw.close();
    }

    static int[] dr={-1,-1,-1,0,1,1,1,0};
    static int[] dc={-1,0,1,1,1,0,-1,-1};

    static class Point{
        int r,c;
        public Point(int r, int c){
            this.r=r;
            this.c=c;
        }
    }

    private static void bfs(int r, int c) {
        Queue<Point> queue = new ArrayDeque<>();
        visit[r][c]=true;
        queue.offer(new Point(r,c));

        while(!queue.isEmpty()){
            Point p=queue.poll();
            for(int d=0;d<8;d++){
                int nr=p.r+dr[d];
                int nc=p.c+dc[d];
                if(nr>=0&&nr<N&&nc>=0&&nc<M&&map[nr][nc]==1&&!visit[nr][nc]){
                    visit[nr][nc]=true;
                    queue.offer(new Point(nr,nc));
                }
            }
        }
    }
}

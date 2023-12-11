import java.io.*;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N;
    static int[][] map;
    static boolean[][][] v;

    static int[] dr={1,-1,0,0};
    static int[] dc={0,0,1,-1};
    static class Point implements Comparable<Point>{
        int r,c,black;
        public Point(int r,int c,int black){
            this.r=r;
            this.c=c;
            this.black=black;
        }

        @Override
        public int compareTo(Point o) {
            return this.black-o.black;
        }
    }

    static PriorityQueue<Point> q=new PriorityQueue<>();
    static int minCnt=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        N=Integer.parseInt(br.readLine());
        map=new int[N][N];
        v=new boolean[N*N][N][N];

        for(int i=0;i<N;i++){
            String word=br.readLine();
            for(int j=0;j<N;j++){
                map[i][j]=Character.getNumericValue(word.charAt(j));
            }
        }

        bfs();

        bw.write(minCnt+"");
        bw.close();
    }

    private static void bfs() {
        q.offer(new Point(0,0,0));
        v[0][0][0]=true;

        while(!q.isEmpty()){
            Point p=q.poll();
            if(p.r==N-1&&p.c==N-1&&p.black<minCnt){
                minCnt=p.black;
                return;
            }

            for(int d=0;d<4;d++){
                int nr=p.r+dr[d];
                int nc=p.c+dc[d];
                if(nr>=0&&nr<N&&nc>=0&&nc<N){
                    if(map[nr][nc]==1&&!v[p.black][nr][nc]){
                        q.offer(new Point(nr,nc, p.black));
                        v[p.black][nr][nc]=true;
                    }
                    if(map[nr][nc]==0&&p.black+1<N*N&&!v[p.black+1][nr][nc]){
                        q.offer(new Point(nr,nc,p.black+1));
                        v[p.black+1][nr][nc]=true;
                    }
                }
            }
        }
    }
}

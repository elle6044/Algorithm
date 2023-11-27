import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int[][] map;
    static int N;
    static int M;


    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        map=new int[N][M];

        for(int i=0;i<N;i++){
            String word = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j]=Character.getNumericValue(word.charAt(j));
            }
        }

        bfs(0,0,1);
        bw.write(minCount+"");
        bw.close();


    }

    static class Point{
        int r,c,cnt;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};
    static int minCount=Integer.MAX_VALUE;

    private static void bfs(int r, int c, int cnt){
        boolean [][] visit = new boolean[N][M];
        Queue<Point> queue = new LinkedList<>();
        visit[r][c] = true;
        queue.offer(new Point(r,c,cnt));
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                Point p = queue.poll();

                if(p.r==N-1&&p.c==M-1&&minCount>p.cnt){
                    minCount=p.cnt;
                }

                for(int d=0;d<4;d++){
                    int nr = p.r+dr[d];
                    int nc = p.c+dc[d];

                    if(nr>=0&&nr<N&&nc>=0&&nc<M&&map[nr][nc]==1&&visit[nr][nc]==false){
                        visit[nr][nc]=true;
                        queue.offer(new Point(nr, nc, p.cnt+1));
                    }
                }
            }
        }
    }
}

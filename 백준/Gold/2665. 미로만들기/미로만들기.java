import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static int[][] map;
    static boolean[][] v;

    static int[] dr={1,-1,0,0};
    static int[] dc={0,0,1,-1};

    static class Point{
        int r,c,black;
        public Point(int r,int c,int black){
            this.r=r;
            this.c=c;
            this.black=black;
        }
    }

    public static void main(String[] args) throws IOException {
        N=Integer.parseInt(br.readLine());
        map=new int[N][N];
        v=new boolean[N][N];

        for(int i=0;i<N;i++){
            String word=br.readLine();
            for(int j=0;j<N;j++){
                map[i][j]=word.charAt(j)-'0';
            }
        }

        bw.write(bfs()+"");
        bw.close();
    }

    private static int bfs() {
        Deque<Point> q=new ArrayDeque<>();
        q.offer(new Point(0,0,0));
        v[0][0]=true;

        while(!q.isEmpty()){
            Point p=q.poll();
            if(p.r==N-1&&p.c==N-1){
                return p.black;
            }

            for(int d=0;d<4;d++){
                int nr=p.r+dr[d];
                int nc=p.c+dc[d];
                if(nr>=0&&nr<N&&nc>=0&&nc<N&&!v[nr][nc]){
                    if(map[nr][nc]==1){
                        q.offerFirst(new Point(nr,nc,p.black));
                        v[nr][nc]=true;
                    }
                    else{
                        q.offerLast(new Point(nr,nc,p.black+1));
                        v[nr][nc]=true;
                    }
                }
            }
        }
        return -1;

    }
}

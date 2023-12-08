import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N,M;
    static char[][] map;
    static boolean[][] v;

    static int[] dr={1,-1,0,0};
    static int[] dc={0,0,1,-1};
    static class Point{
        int r,c,cnt;
        char type;
        public Point(int r, int c, int cnt, char type){
            this.r=r;
            this.c=c;
            this.cnt=cnt;
            this.type=type;
        }
    }

    static Queue<Point> q = new ArrayDeque<>();
    static int minCnt = Integer.MAX_VALUE;

    static int sr=0;
    static int sc=0;
    static int er=0;
    static int ec=0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        map=new char[N][M];
        v=new boolean[N][M];


        for(int i=0;i<N;i++){
            String word = br.readLine();
            for(int j=0;j<M;j++){
                char input=word.charAt(j);
                map[i][j]=input;
                if(input=='*'){
                    q.offer(new Point(i,j,0,'*'));
                }
                else if(input=='D'){
                    er=i;
                    ec=j;
                }
                else if(input=='S'){
                    sr=i;
                    sc=j;
                }
            }
        }

        q.offer(new Point(sr,sc,0,'S'));
        v[sr][sc]=true;
        bfs();

        if(minCnt==Integer.MAX_VALUE){
            bw.write("KAKTUS");
        }
        else{
            bw.write(minCnt+"");
        }
        bw.close();
    }

    private static void bfs() {
        while(!q.isEmpty()){
            Point p=q.poll();
//            if(p.r==er&&p.c==ec&&p.type=='S'&&p.cnt<minCnt){
//                minCnt=p.cnt;
//                return;
//            }

            for(int d=0;d<4;d++){
                int nr=p.r+dr[d];
                int nc=p.c+dc[d];
                if(nr>=0&&nr<N&&nc>=0&&nc<M&&!v[nr][nc]){
                    if(map[nr][nc]=='.'){
                        q.offer(new Point(nr,nc, p.cnt+1, p.type));
                        v[nr][nc]=true;
                    }
                    else if(map[nr][nc]=='D'){
                        if(p.type=='S'){
                            minCnt=p.cnt+1;
                            return;
//                            q.offer(new Point(nr,nc, p.cnt+1, p.type));
//                            v[nr][nc]=true;
                        }
                    }
                }
            }
        }
    }
}

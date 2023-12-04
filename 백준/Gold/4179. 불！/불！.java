import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N,M;
    static char[][]map;
    static boolean[][]v;

    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        map=new char[N][M];
        v=new boolean[N][M];

        for(int i=0;i<N;i++){
            String input = br.readLine();
            for(int j=0;j<M;j++){
                char in = input.charAt(j);
                map[i][j]=in;
                if(in=='F'){
                    q.offer(new Point(i,j,0,'F'));
                    v[i][j]=true;
                }
            }
        }

        bfs();

        if(minCnt==Integer.MAX_VALUE){
            bw.write("IMPOSSIBLE");
        }
        else{
            bw.write(minCnt+"");
        }

        bw.close();
    }

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
    static int minCnt=Integer.MAX_VALUE;

    static Queue<Point> q = new ArrayDeque<>();
    private static void bfs() {
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]=='J'){
                    q.offer(new Point(i,j,0,'J'));
                    v[i][j]=true;
                }
            }
        }

        while(!q.isEmpty()){
            Point p=q.poll();
            if((p.r==0||p.c==0||p.r==N-1||p.c==M-1)&&p.type=='J'&&p.cnt<minCnt){
                minCnt=p.cnt+1;
                return;
            }

            for(int d=0;d<4;d++){
                int nr=p.r+dr[d];
                int nc=p.c+dc[d];
                if(nr>=0&&nr<N&&nc>=0&&nc<M&&!v[nr][nc]&&map[nr][nc]=='.'){
                    if(p.type=='J'){
                        q.offer(new Point(nr,nc,p.cnt+1,'J'));
                        map[nr][nc]='J';
                    }
                    else{
                        q.offer(new Point(nr,nc,p.cnt+1,'F'));
                        map[nr][nc]='F';
                    }
                    v[nr][nc]=true;
                }
            }
        }


    }
}

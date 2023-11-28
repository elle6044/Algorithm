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

    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        map=new int[N][M];


        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int count=0;
        while(true){
            int end=0;
            v=new boolean[N][M];

            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(map[i][j]!=0&&!v[i][j]){
                        bfs(i,j);
                        end++;
                    }
                }
            }
            if(end>=2) break;
            else if(end==0){
                count=0;
                break;
            }
            count++;
        }

        bw.write(count+"");
        bw.close();
    }

    static class Point{
        int r,c;
        public Point(int r, int c){
            this.r=r;
            this.c=c;
        }
    }

    static int[] dr={1,-1,0,0};
    static int[] dc={0,0,1,-1};
    private static void bfs(int i, int j) {
        Queue<Point> q=new ArrayDeque<>();
        v[i][j]=true;
        q.offer(new Point(i,j));
        while(!q.isEmpty()){
            Point p=q.poll();
            for(int d=0;d<4;d++){
                int nr=p.r+dr[d];
                int nc=p.c+dc[d];
                if(nr>=0&&nr<N&&nc>=0&&nc<M&&!v[nr][nc]){
                    if(map[nr][nc]==0){
                        if(map[p.r][p.c]>0){
                            map[p.r][p.c]--;
                        }
                    }
                    else{
                        v[nr][nc]=true;
                        q.offer(new Point(nr,nc));
                    }
                }
            }
        }
    }
}

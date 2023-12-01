import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N,L,R;
    static int[][] map;
    static boolean[][] v;
    static boolean check;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        L=Integer.parseInt(st.nextToken());
        R=Integer.parseInt(st.nextToken());

        map=new int[N][N];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int count=0;
        while(true){
            v=new boolean[N][N];
            check = false;

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(!v[i][j]){
                        bfs(i,j);
                    }
                }
            }
            if(!check) break;
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
    static int[] dc={0,0,1,-1,};

    static Queue<Point> q=new ArrayDeque<>();
    static Queue<Point> q2 = new ArrayDeque<>();
    private static void bfs(int i, int j) {

        int count=1;
        int sum=map[i][j];
        v[i][j]=true;
        q.offer(new Point(i,j));
        q2.offer(new Point(i,j));

        while(!q.isEmpty()){
            Point p=q.poll();
            for(int d=0;d<4;d++){
                int nr=p.r+dr[d];
                int nc=p.c+dc[d];
                if(nr>=0&&nr<N&&nc>=0&&nc<N&&!v[nr][nc]){
                    int gap=Math.abs(map[p.r][p.c]-map[nr][nc]);
                    if(gap>=L&&gap<=R){
                        v[nr][nc]=true;
                        q.offer(new Point(nr,nc));
                        q2.offer(new Point(nr,nc));
                        count++;
                        sum+=map[nr][nc];
                        check=true;
                    }
                }
            }
        }
        int newValue=sum/count;
        while(!q2.isEmpty()){
            Point p=q2.poll();
            map[p.r][p.c]=newValue;
        }
    }
}

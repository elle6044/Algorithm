import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N,M,K;
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

    static Queue<Point> q=new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        M=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        map=new int[N][M];
        v=new boolean[N][M];

        for(int k=0;k<K;k++){
            st=new StringTokenizer(br.readLine());
            int lbx=Integer.parseInt(st.nextToken());
            int lby=Integer.parseInt(st.nextToken());
            int rtx=Integer.parseInt(st.nextToken());
            int rty=Integer.parseInt(st.nextToken());
            for(int i=lbx;i<rtx;i++){
                for(int j=lby;j<rty;j++){
                    map[i][j]=1;
                }
            }
        }

        int cnt=0;
        ArrayList<Integer> answers=new ArrayList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]==0&&!v[i][j]){
                    answers.add(bfs(i,j));
                    cnt++;
                }
            }
        }
        Collections.sort(answers);

        bw.write(cnt+"\n");
        for(int answer:answers){
            bw.write(answer+" ");
        }
        bw.close();
    }

    private static int bfs(int i, int j) {
        q.offer(new Point(i,j));
        v[i][j]=true;
        int count=1;

        while(!q.isEmpty()){
            Point p=q.poll();
            for(int d=0;d<4;d++){
                int nr=p.r+dr[d];
                int nc=p.c+dc[d];
                if(nr>=0&&nr<N&&nc>=0&&nc<M&&!v[nr][nc]&&map[nr][nc]==0){
                    q.offer(new Point(nr,nc));
                    v[nr][nc]=true;
                    count++;
                }
            }
        }
        return count;
    }
}

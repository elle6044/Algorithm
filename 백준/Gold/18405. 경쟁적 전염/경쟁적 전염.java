import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N,K;
    static int S,X,Y;
    static int[][] map;
    static boolean[][] v;

    static int[] dr={1,-1,0,0};
    static int[] dc={0,0,1,-1};

    static class Point{
        int r,c,type;
        public Point(int r, int c, int type){
            this.r=r;
            this.c=c;
            this.type=type;
        }
    }

    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        map=new int[N][N];
        v=new boolean[N][N];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        st=new StringTokenizer(br.readLine());
        S=Integer.parseInt(st.nextToken());
        X=Integer.parseInt(st.nextToken())-1;
        Y=Integer.parseInt(st.nextToken())-1;

        bfs();

        bw.write(answer+"");
        bw.close();
    }

    static int answer=0;

    private static void bfs() {
        Queue<Point> q = new ArrayDeque<>();
        for(int k=1;k<=K;k++){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(map[i][j]==k){
                        q.offer(new Point(i,j,k));
                        v[i][j]=true;
                    }
                }
            }
        }
        int count=0;
        while(!q.isEmpty()){
//            for(int i=0;i<N;i++){
//                for(int j=0;j<N;j++){
//                    System.out.print(map[i][j]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println();

            if(count==S){
                answer=map[X][Y];
                return;
            }

            int size=q.size();
            for(int s=0;s<size;s++){
                Point p=q.poll();
                for(int d=0;d<4;d++){
                    int nr=p.r+dr[d];
                    int nc=p.c+dc[d];
                    if(nr>=0&&nr<N&&nc>=0&&nc<N&&!v[nr][nc]&&map[nr][nc]==0){
                        q.offer(new Point(nr,nc,p.type));
                        v[nr][nc]=true;
                        map[nr][nc]=p.type;
                    }
                }
            }
            count++;
        }
        answer=map[X][Y];
    }
}

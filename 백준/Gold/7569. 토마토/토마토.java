import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N,M,H;
    static int [][][] map;
    static boolean [][][] v;
    static Queue<Point> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        M=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());
        H=Integer.parseInt(st.nextToken());

        map=new int[H][N][M];
        v=new boolean[H][N][M];

        for(int h=0;h<H;h++){
            for(int n=0;n<N;n++){
                st=new StringTokenizer(br.readLine());
                for(int m=0;m<M;m++){
                    int in=Integer.parseInt(st.nextToken());
                    map[h][n][m]=in;
                    if(in==1){
                        v[h][n][m]=true;
                        q.offer(new Point(h,n,m));
                    }
                }
            }
        }

        bfs();
        bw.write(count+"");
        bw.close();

    }


    static class Point{
        int h,r,c;
        public Point(int h, int r, int c){
            this.h=h;
            this.r=r;
            this.c=c;
        }
    }

    static int[] dh={-1,1};
    static int[] dr={1,-1,0,0};
    static int[] dc={0,0,1,-1};

    static int count=-1;
    static void bfs(){
        while(!q.isEmpty()){
            int size = q.size();
            count++;
            for(int s=0;s<size;s++){
                Point p=q.poll();

                for(int d=0;d<2;d++){
                    int nh=p.h+dh[d];
                    if(nh>=0&&nh<H&&map[nh][p.r][p.c]==0&&!v[nh][p.r][p.c]){
                        v[nh][p.r][p.c]=true;
                        map[nh][p.r][p.c]=1;
                        q.offer(new Point(nh,p.r,p.c));
                    }
                }

                for(int d=0;d<4;d++){
                    int nr=p.r+dr[d];
                    int nc=p.c+dc[d];
                    if(nr>=0&&nr<N&&nc>=0&&nc<M&&map[p.h][nr][nc]==0&&!v[p.h][nr][nc]){
                        v[p.h][nr][nc]=true;
                        map[p.h][nr][nc]=1;
                        q.offer(new Point(p.h,nr,nc));
                    }
                }
            }
        }

        for(int h=0;h<H;h++){
            for(int n=0;n<N;n++){
                for(int m=0;m<M;m++){
                    if(map[h][n][m]==0){
                        count=-1;
                    }
                }
            }
        }
    }
}

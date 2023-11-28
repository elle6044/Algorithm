import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
            boolean check=false;
            L:for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(map[i][j]!=0){
                        check=true;
                        break L;
                    }
                }
            }

            if(!check) break;
            v=new boolean[N][M];
            bfs();
            count++;

            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(map[i][j]!=0) map[i][j]=1;
//                    System.out.print(map[i][j]+" ");
                }
//                System.out.println();
            }
//            System.out.println();
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

    static void bfs(){
        Queue<Point> q=new ArrayDeque();
        v[0][0]=true;
        q.offer(new Point(0,0));
        while(!q.isEmpty()){
            Point p=q.poll();
            for(int d=0;d<4;d++){
                int nr=p.r+dr[d];
                int nc=p.c+dc[d];
                if(nr>=0&&nr<N&&nc>=0&&nc<M&&!v[nr][nc]){
                    if(map[nr][nc]==0){
                        v[nr][nc]=true;
                        q.offer(new Point(nr,nc));
                    }
                    else{
                        map[nr][nc]++;
                        if(map[nr][nc]==3){
                            map[nr][nc]=0;
                            v[nr][nc]=true;
                        }
                    }
                }
            }
        }
    }
}

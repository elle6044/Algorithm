import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static int[] dr={-1,0,0,1};
    static int[] dc={0,-1,1,0};
    static int[][] map;
    static boolean[][] v;

    public static void main(String[] args) throws Exception {
        N=nextInt();
        map=new int[N][N];
        v=new boolean[N][N];
        int sr=0;
        int sc=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                int input=nextInt();
                map[i][j]=input;
                if(input==9){
                    sr=i;
                    sc=j;
                }
            }
        }

        bfs(sr,sc);
        bw.write(answer+"");
        bw.close();
    }

    static int answer=0;
    private static void bfs(int sr, int sc) {
        Queue<Point> q=new ArrayDeque<>();
        PriorityQueue<Point> pq=new PriorityQueue<>();

        q.offer(new Point(sr,sc,0,2,0));
        v[sr][sc]=true;
        map[sr][sc]=0;

        while(!q.isEmpty()){
            int size=q.size();
            for(int s=0;s<size;s++){
                Point p=q.poll();
                for(int d=0;d<4;d++){
                    int nr=p.r+dr[d];
                    int nc=p.c+dc[d];
                    if(nr>=0&&nr<N&&nc>=0&&nc<N&&!v[nr][nc]){
                        if(map[nr][nc]==0){
                            q.offer(new Point(nr,nc,p.temp,p.size,p.cnt+1));
                            v[nr][nc]=true;
                        }
                        else{
                            if(p.size>map[nr][nc]){
                                pq.offer(new Point(nr,nc,p.temp+1,p.size,p.cnt+1));
                            }
                            else if(p.size==map[nr][nc]){
                                q.offer(new Point(nr,nc,p.temp,p.size,p.cnt+1));
                                v[nr][nc]=true;
                            }
                        }
                    }
                }
            }

            if(!pq.isEmpty()){
                q.clear();
                v=new boolean[N][N];
                Point np=pq.poll();
                if(np.temp==np.size){
                    q.offer(new Point(np.r,np.c,0,np.size+1,np.cnt));
                }
                else{
                    q.offer(new Point(np.r,np.c,np.temp,np.size,np.cnt));
                }
                v[np.r][np.c]=true;
                map[np.r][np.c]=0;
                answer=np.cnt;

                pq.clear();

            }
        }
    }

    static class Point implements Comparable<Point>{
        int r,c,temp,size,cnt;
        public Point(int r,int c,int temp,int size,int cnt){
            this.r=r;
            this.c=c;
            this.temp=temp;
            this.size=size;
            this.cnt=cnt;
        }

        @Override
        public int compareTo(Point o) {
            return this.r==o.r?this.c-o.c:this.r-o.r;
        }
    }


    static int nextInt() throws Exception {
        int sign = 0;
        int n = 0;
        int c;
        while ((c = System.in.read()) <= 32);
        if(c == 45) {
            sign = 1;
            c = System.in.read();
        }
        do n = (n << 3) + (n << 1) + (c & 15);
        while ((c = System.in.read()) > 47 && c < 58);
        return sign == 0 ? n : ~n + 1;
    }

}

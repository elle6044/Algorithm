import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static char[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        N=Integer.parseInt(br.readLine());
        map=new char[N][N];
        visit=new boolean[N][N];
        for(int i=0;i<N;i++){
            String word = br.readLine();
            for(int j=0;j<N;j++){
                map[i][j]=word.charAt(j);
            }
        }

        int count1=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visit[i][j]){
                    bfs1(i,j);
                    count1++;
                }
            }
        }

        int count2=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(visit[i][j]){
                    bfs2(i,j);
                    count2++;
                }
            }
        }

        bw.write(count1+" "+count2);
        bw.close();

    }

    static int[] dr={1,-1,0,0};
    static int[] dc={0,0,1,-1};

    static class Point{
        int r,c;
        char type;

        public Point(int r, int c, char type){
            this.r=r;
            this.c=c;
            this.type=type;
        }
    }

    static void bfs1(int r, int c){
        Queue<Point> queue = new LinkedList<>();
        visit[r][c]=true;
        queue.offer(new Point(r,c,map[r][c]));

        while(!queue.isEmpty()){
            Point p = queue.poll();
            for(int d=0;d<4;d++){
                int nr=p.r+dr[d];
                int nc=p.c+dc[d];
                if(nr>=0&&nr<N&&nc>=0&&nc<N&&p.type==map[nr][nc]&&!visit[nr][nc]){
                    visit[nr][nc]=true;
                    queue.offer(new Point(nr,nc,p.type));
                }
            }
        }
    }

    static void bfs2(int r, int c){
        Queue<Point> queue = new LinkedList<>();
        visit[r][c]=false;
        queue.offer(new Point(r,c,map[r][c]));

        while(!queue.isEmpty()){
            Point p = queue.poll();
            for(int d=0;d<4;d++){
                int nr=p.r+dr[d];
                int nc=p.c+dc[d];
                if(nr>=0&&nr<N&&nc>=0&&nc<N&&visit[nr][nc]){
                    if(p.type=='B'){
                        if(map[nr][nc]=='B'){
                            visit[nr][nc]=false;
                            queue.offer(new Point(nr,nc,p.type));
                        }
                    }
                    else{
                        if(map[nr][nc]=='R'||map[nr][nc]=='G'){
                            visit[nr][nc]=false;
                            queue.offer(new Point(nr,nc,map[nr][nc]));
                        }
                    }
                }
            }
        }
    }
}

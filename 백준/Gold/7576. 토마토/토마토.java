import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N,M;
    static int[][] map;
    static boolean[][] visit;
    static Queue<Point> queue=new LinkedList<>();

    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        M=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());

        map=new int[N][M];
        visit=new boolean[N][M];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                int input = Character.getNumericValue(st.nextToken().charAt(0));
                map[i][j] = input;
                if(input==1) queue.offer(new Point(i,j));
            }
        }

        bfs();

        if(count>0) count--;

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

    static int count;
    static int[] dr={1,-1,0,0};
    static int[] dc={0,0,1,-1};

    static void bfs(){
        while(!queue.isEmpty()){
            int size = queue.size();

            for(int s=0;s<size;s++){
                Point p = queue.poll();

                for(int d=0;d<4;d++){
                    int nr = p.r+dr[d];
                    int nc = p.c+dc[d];
                    if(nr>=0&&nr<N&&nc>=0&&nc<M&&map[nr][nc]==0){
                        map[nr][nc]=1;
                        queue.offer(new Point(nr,nc));
                    }
                }
            }
            count++;
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]==0){
                    count=-1;
                }
            }
        }
    }
}

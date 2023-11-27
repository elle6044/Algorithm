import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N;
    static int[][]map;
    static boolean[][] visit;


    public static void main(String[] args) throws IOException {
        N=Integer.parseInt(br.readLine());
        map=new int[N][N];
        visit=new boolean[N][N];

        for(int i=0;i<N;i++){
            String word = br.readLine();
            for(int j=0;j<N;j++){
                map[i][j]=Character.getNumericValue(word.charAt(j));
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]!=0&&visit[i][j]==false){
                    bfs(i,j);
                }
            }
        }

        Collections.sort(counts);

        bw.write(counts.size()+"");
        for(int i=0;i<counts.size();i++){
            bw.write("\n"+counts.get(i));
        }
        bw.close();
    }


    static class Point{
        int r,c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[] dr={1,-1,0,0};
    static int[] dc={0,0,1,-1};


    static ArrayList<Integer> counts = new ArrayList<>();
    static void bfs(int r, int c){
        Queue<Point> queue = new LinkedList<>();
        int count=1;
        visit[r][c]=true;
        queue.offer(new Point(r,c));
        while(!queue.isEmpty()){
            Point p = queue.poll();

            for(int d=0;d<4;d++){
                int nr=p.r+dr[d];
                int nc=p.c+dc[d];
                if(nr>=0&&nr<N&&nc>=0&&nc<N&&map[nr][nc]!=0&&visit[nr][nc]==false){
                    visit[nr][nc]=true;
                    queue.offer(new Point(nr,nc));
                    count++;
                }
            }
        }
        counts.add(count);
    }
}

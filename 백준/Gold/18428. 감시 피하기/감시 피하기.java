import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static char[][] map;

    static ArrayList<Point> teachers=new ArrayList<>();
    static class Point{
        int r,c;
        public Point(int r,int c){
            this.r=r;
            this.c=c;
        }
    }


    public static void main(String[] args) throws IOException {
        N=Integer.parseInt(br.readLine());
        map=new char[N][N];
        for(int i=0;i<N;i++){
            String input=br.readLine();
            for(int j=0;j<N;j++){
                char word= input.charAt(j*2);
                map[i][j]=word;
                if(word=='T'){
                    teachers.add(new Point(i,j));
                }
            }
        }

        baek(0,0,0);

        bw.write(answer?"YES":"NO");
        bw.close();
    }

    static boolean answer=false;
    private static void baek(int r, int c, int cnt) {
        if(cnt==3){
            if(isPossible()){
                answer=true;
            }
            return;
        }

        for(int i=r;i<N;i++){
            for(int j=i==r?c:0;j<N;j++){
                if(map[i][j]=='X'){
                    map[i][j]='O';
                    baek(i,j,cnt+1);
                    map[i][j]='X';
                }
            }
        }
    }

    static int[] dr={1,-1,0,0};
    static int[] dc={0,0,1,-1};
    private static boolean isPossible() {
        for (Point teacher : teachers) {
            for(int d=0;d<4;d++){
                int nr=teacher.r;
                int nc=teacher.c;
                while (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    if (map[nr][nc] == 'S') {
                        return false;
                    }
                    if(map[nr][nc]=='O'){
                        break;
                    }
                    nr += dr[d];
                    nc += dc[d];
                }
            }
        }
        return true;
    }
}

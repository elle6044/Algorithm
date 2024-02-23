import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    static int N,M;
    static int[][][] dr={{{0},{1},{0},{-1}},
            {{0,0},{-1,1}},
            {{-1,0},{0,1},{1,0},{0,-1}},
            {{0,-1,0},{-1,0,1},{0,1,0},{1,0,-1}},
            {{-1,0,1,0}}};
    static int[][][] dc={{{1},{0},{-1},{0}},
            {{1,-1},{0,0}},
            {{0,1},{1,0},{0,-1},{-1,0}},
            {{-1,0,1},{0,1,0},{1,0,-1},{0,-1,0}},
            {{0,1,0,-1}}};

    static int[][] map;

    static ArrayList<Point> cctvList=new ArrayList<>();

    static class Point{
        int type,r,c;
        public Point(int type, int r, int c){
            this.type=type;
            this.r=r;
            this.c=c;
        }
    }

    public static void main(String[] args) throws Exception {
        N=nextInt();
        M=nextInt();
        map=new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                int input=nextInt();
                map[i][j]=input;
                if(input>=1&&input<=5){
                    cctvList.add(new Point(input-1,i,j));
                }
            }
        }

        back(0);

        bw.write(answer+"");
        bw.close();
    }

    static int answer=Integer.MAX_VALUE;
    private static void back(int cnt) {
        if(cnt==cctvList.size()){
            int sum=0;
            for (int[] ints : map) {
                for (int i : ints) {
                    if(i==0){
                        sum++;
                    }
                }
            }
            answer=Math.min(answer,sum);
            return;
        }

        Point cctv=cctvList.get(cnt);
        for(int j=0;j<dr[cctv.type].length;j++){
            for(int d=0;d<dr[cctv.type][j].length;d++){
                int nr=cctv.r+dr[cctv.type][j][d];
                int nc=cctv.c+dc[cctv.type][j][d];
                while(true){
                    if(nr<0||nr>=N||nc<0||nc>=M){
                        break;
                    }
                    if(map[nr][nc]==6) break;

                    map[nr][nc]+=1;

                    nr+=dr[cctv.type][j][d];
                    nc+=dc[cctv.type][j][d];
                }
            }

            back(cnt+1);

            for(int d=0;d<dr[cctv.type][j].length;d++){
                int nr=cctv.r+dr[cctv.type][j][d];
                int nc=cctv.c+dc[cctv.type][j][d];
                while(true){
                    if(nr<0||nr>=N||nc<0||nc>=M){
                        break;
                    }
                    if(map[nr][nc]==6) break;

                    map[nr][nc]-=1;

                    nr+=dr[cctv.type][j][d];
                    nc+=dc[cctv.type][j][d];
                }
            }
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

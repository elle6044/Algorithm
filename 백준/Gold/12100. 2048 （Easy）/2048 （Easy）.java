import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;

    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,-1,1};


    public static void main(String[] args) throws Exception {
        N=nextInt();
        int[][] map=new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                map[i][j]=nextInt();
            }
        }

        back(0,map);

        bw.write(max+"");
        bw.close();

    }

    static int max=0;
    private static void back(int cnt, int[][] map) {
        if(cnt==5){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    max=Math.max(max,map[i][j]);
                }
            }
            return;
        }

        int[][] newMap=new int[N][N];

        for(int d=0;d<4;d++){
            for(int i=0;i<N;i++){
                newMap[i]=Arrays.copyOf(map[i],N);
            }
            move(d,newMap);

            back(cnt+1,newMap);
        }
    }


    static void move(int d, int[][]newMap){
        boolean[][] v=new boolean[N][N];
        switch (d){
            case 0:
                for(int i=1;i<N;i++){
                    for(int j=0;j<N;j++){
                        calculate(i,j,d,newMap,v);
                    }
                }
                break;
            case 1:
                for(int i=N-1;i>=0;i--){
                    for(int j=0;j<N;j++){
                        calculate(i,j,d,newMap,v);
                    }
                }
                break;
            case 2:
                for(int i=0;i<N;i++){
                    for(int j=1;j<N;j++){
                        calculate(i,j,d,newMap,v);
                    }
                }
                break;
            case 3:
                for(int i=0;i<N;i++){
                    for(int j=N-1;j>=0;j--){
                        calculate(i,j,d,newMap,v);
                    }
                }
                break;
        }
    }

    private static void calculate(int i, int j, int d, int[][] newMap, boolean[][] v) {
        if(newMap[i][j]>0){
            int nr=i;
            int nc=j;
            while(true){
                nr+=dr[d];
                nc+=dc[d];
                if(nr<0||nr>=N||nc<0||nc>=N) break;

                if(newMap[nr][nc]!=0) {
                    if(newMap[i][j]==newMap[nr][nc]){
                        if(v[nr][nc]){
                            break;
                        }
                        else{
                            v[nr][nc]=true;
                            nr+=dr[d];
                            nc+=dc[d];
                            break;
                        }
                    }
                    else if(newMap[i][j]!=newMap[nr][nc]){
                        break;
                    }
                }
            }
            nr-=dr[d];
            nc-=dc[d];
            if(nr!=i||nc!=j){
                newMap[nr][nc]+=newMap[i][j];
                newMap[i][j]=0;
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

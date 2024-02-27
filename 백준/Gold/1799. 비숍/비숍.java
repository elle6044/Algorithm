import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static int[][] map;
    static boolean[] check1;
    static boolean[] check2;
    static int maxCnt;
    static int oneCnt;

    public static void main(String[] args) throws Exception {
        N=nextInt();
        map=new int[N][N];
        maxCnt=2*N-1;
        check1=new boolean[maxCnt];
        check2=new boolean[maxCnt];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                int input=nextInt();
                map[i][j]=input;
                if(input==1){
                    oneCnt++;
                }
            }
        }

        back(0,0);

        bw.write(answer+"");
        bw.close();
    }

    static int answer=0;
    private static void back(int cnt,int allCnt) {

        if(allCnt==2*N-1){
            return;
        }
        if(cnt==2*N-2){
            return;
        }

        boolean check=false;
        int n=allCnt;
        for(int i=n<N?0:n-(N-1);i<=Math.min(n,N-1);i++){
            int j=n-i;

            if(map[i][j]==1){
                if(!check1[i+j]&&!check2[N-1-i+j]){
                    check=true;
                    map[i][j]=0;
                    check1[i+j]=true;
                    check2[N-1-i+j]=true;
                    cnt++;
                    answer=Math.max(answer,cnt);

                    back(cnt,allCnt+1);

                    map[i][j]=1;
                    check1[i+j]=false;
                    check2[N-1-i+j]=false;
                    cnt--;
                }
            }
        }
        if(!check){
            back(cnt,allCnt+1);
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

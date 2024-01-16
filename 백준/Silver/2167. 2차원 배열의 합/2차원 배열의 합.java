import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int N=nextInt();
        int M=nextInt();

        int[][]map=new int[N+1][M+1];
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                map[i][j]=map[i-1][j]+map[i][j-1]-map[i-1][j-1]+nextInt();
            }
        }

        int K=nextInt();
        for(int i=0;i<K;i++){
            int sr=nextInt();
            int sc=nextInt();
            int er=nextInt();
            int ec=nextInt();

            bw.write(map[er][ec]-map[er][sc-1]-map[sr-1][ec]+map[sr-1][sc-1]+"\n");
        }
        bw.close();
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

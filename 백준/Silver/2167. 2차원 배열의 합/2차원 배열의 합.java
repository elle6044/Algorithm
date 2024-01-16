import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int N=nextInt();
        int M=nextInt();

        int[][]map=new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                map[i][j]=nextInt();
            }
        }

        int K=nextInt();
        for(int i=0;i<K;i++){
            int sum=0;
            int sr=nextInt()-1;
            int sc=nextInt()-1;
            int er=nextInt()-1;
            int ec=nextInt()-1;
            for(int r=sr;r<=er;r++){
                for(int c=sc;c<=ec;c++){
                    sum+=map[r][c];
                }
            }

            bw.write(sum+"\n");
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

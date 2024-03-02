import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    static int[][] map=new int[11][11];
    static boolean[] v=new boolean[11];

    public static void main(String[] args) throws Exception {
        int T=nextInt();
        for(int t=0;t<T;t++){
            for(int i=0;i<11;i++){
                for(int j=0;j<11;j++){
                    map[i][j]=nextInt();
                }
            }

            baek(0,0);
            bw.write(max+"\n");
            max=0;
        }
        bw.close();
    }

    static int max=0;
    private static void baek(int cnt, int sum) {
        if(cnt==11){
            max=Math.max(max,sum);
            return;
        }

        for(int i=0;i<11;i++){
            if(!v[i]&&map[cnt][i]>0){
                v[i]=true;
                baek(cnt+1,sum+map[cnt][i]);
                v[i]=false;
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

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static int N,K;
    static int[] map;
    static boolean[] v;


    public static void main(String[] args) throws Exception {
        N=nextInt();
        K=nextInt();
        map=new int[N];
        v=new boolean[N];
        for(int i=0;i<N;i++){
            map[i]=nextInt();
        }

        back(0,500);
        bw.write(answer+"");
        bw.close();
    }

    static int answer=0;
    private static void back(int cnt, int sum) {
        if(cnt==N){
            answer++;
            return;
        }

        for(int i=0;i<N;i++){
            if(!v[i]&&sum+map[i]-K>=500){
                v[i]=true;
                back(cnt+1,sum+map[i]-K);
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

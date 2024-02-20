import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    static int N,S;
    static int[] num;
    static int[] array;
    static boolean[] v;

    public static void main(String[] args) throws Exception {
        N=nextInt();
        S=nextInt();
        num=new int[N];
        for(int i=0;i<N;i++){
            num[i]=nextInt();
        }

        for(int i=1;i<=N;i++){
            array=new int[i];
            v=new boolean[N];
            back(i,0);
        }

        bw.write(answer+"");
        bw.close();
    }

    static int answer=0;
    private static void back(int cnt, int idx) {
        if(cnt==0){
            int sum=0;
            for (int j : array) {
                sum += j;
            }
            if(sum==S){
                answer++;
            }
            return;
        }

        for(int i=idx;i<N;i++){
            if(!v[i]){
                v[i]=true;
                array[cnt-1]=num[i];
                back(cnt-1,i);
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

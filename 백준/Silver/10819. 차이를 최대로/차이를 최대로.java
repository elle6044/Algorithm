import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static int[] num;
    static int[] array;
    static boolean[] v;

    public static void main(String[] args) throws Exception {
        N=nextInt();
        num=new int[N];
        for(int i=0;i<N;i++){
            num[i]=nextInt();
        }

        array=new int[N];
        v=new boolean[N];

        back(0);

        bw.write(max+"");
        bw.close();
    }

    static int max=Integer.MIN_VALUE;
    private static void back(int cnt) {
        if(cnt==N){
            int sum=0;
            for(int i=0;i<N-1;i++){
                sum+=Math.abs(array[i]-array[i+1]);
            }

            max=Math.max(max,sum);

            return;
        }

        for(int i=0;i<N;i++){
            if(!v[i]){
                array[cnt]=num[i];
                v[i]=true;
                back(cnt+1);
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

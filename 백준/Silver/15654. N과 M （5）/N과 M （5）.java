import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    static int N,M;
    static int[] num;
    static int[] array;
    static boolean[] v;

    static StringBuilder sb=new StringBuilder();

    public static void main(String[] args) throws Exception {
        N=nextInt();
        M=nextInt();
        num=new int[N];
        for(int i=0;i<N;i++){
            num[i]=nextInt();
        }
        Arrays.sort(num);

        array=new int[M];
        v=new boolean[N];

        back(0);

        bw.write(sb.toString());
        bw.close();
    }

    private static void back(int cnt) {
        if(cnt==M){
            for (int i : array) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
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

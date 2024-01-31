import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static int N,K;
    static int[] num;
    static int max=0;

    public static void main(String[] args) throws Exception {
        N=nextInt();
        K=nextInt();
        num=new int[K];
        for(int i=0;i<K;i++){
            num[i]=nextInt();
        }

        recursive(0);
        bw.write(max+"");
        bw.close();
    }

    private static void recursive(int number) {
        if(number>N) return;
        if(number>max) max=number;

        for(int i=0;i<K;i++){
            recursive(number*10+num[i]);
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

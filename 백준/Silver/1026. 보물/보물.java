import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int N=nextInt();
        Integer[] a=new Integer[N];
        Integer[] b=new Integer[N];
        for(int i=0;i<N;i++){
            a[i]=nextInt();
        }
        for(int i=0;i<N;i++){
            b[i]=nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b, Collections.reverseOrder());

        int answer=0;
        for(int i=0;i<N;i++){
            answer+=a[i]*b[i];
        }
        bw.write(answer+"");
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

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int E=nextInt();
        int S=nextInt();
        int M=nextInt();

        int cnt=1;
        while ((cnt%15==0?15:cnt%15)!=E||
                (cnt%28==0?28:cnt%28)!=S||
                (cnt%19==0?19:cnt%19)!=M)
        {
            cnt++;
        }

        bw.write(cnt+"");
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

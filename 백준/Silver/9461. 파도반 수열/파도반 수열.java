import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int T=nextInt();
        for(int t=0;t<T;t++){
            int num=nextInt();
            if(num<4){
                bw.write("1\n");
                continue;
            }

            long[] array=new long[num];
            for(int i=0;i<3;i++){
                array[i]=1;
            }

            for(int i=3;i<num;i++){
                array[i]=array[i-2]+array[i-3];
            }

            bw.write(array[num-1]+"\n");
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

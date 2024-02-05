import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int N=nextInt();
        Integer[] array=new Integer[N];
        for(int i=0;i<N;i++){
            array[i]=nextInt();
        }
        Arrays.sort(array, Collections.reverseOrder());

        int answer=0;
        for(int i=0;i<N;i++){
            int temp=(i+1)*array[i];
            if(temp>=answer){
                answer=temp;
            }
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

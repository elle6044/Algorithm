import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int N=nextInt();
        HashSet<Integer> hashSet=new HashSet<>(N);
//        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            hashSet.add(nextInt());
        }

        int M=nextInt();
        for(int i=0;i<M;i++){
            if(hashSet.contains(nextInt())){
                bw.write("1\n");
            }
            else{
                bw.write("0\n");
            }
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

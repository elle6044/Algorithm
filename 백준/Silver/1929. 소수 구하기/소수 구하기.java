import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int N=nextInt();
        int M=nextInt();

        boolean[] isNotPrime=new boolean[M+1];
        isNotPrime[0]=true;
        isNotPrime[1]=true;

        for(int i=2;i*i<=M;i++){
            if(!isNotPrime[i]){
                for(int j=i*i;j<=M;j+=i){
                    isNotPrime[j]=true;
                }
            }
        }

        for(int i=Math.max(2,N);i<=M;i++){
            if(!isNotPrime[i]){
                bw.write(i+"\n");
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

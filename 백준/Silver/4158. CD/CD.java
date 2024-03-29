import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        while(true){
            int N=nextInt();
            int M=nextInt();
            if(N==0&&M==0) break;


            Set<Integer> set=new HashSet<>();

            for(int i=0;i<N;i++){
                set.add(nextInt());
            }

            int cnt=0;
            for(int i=0;i<M;i++){
                if(set.contains(nextInt())){
                    cnt++;
                }
            }


            bw.write(cnt+"\n");
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

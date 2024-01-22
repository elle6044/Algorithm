import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        long T=nextLong();
        for(int t=0;t<T;t++){
            int N=(int)nextLong();
            Map<Long,Integer> map=new HashMap<>(N);
            int half=N/2+1;
            boolean check=false;

            for(int i=0;i<N;i++){
                long newNum=nextLong();
                if(check) continue;
                int newCnt=map.getOrDefault(newNum,0)+1;
                map.put(newNum,newCnt);
                if(newCnt>=half){
                    bw.write(newNum+"\n");
                    check=true;
                }
            }
            if(check) continue;
            bw.write("SYJKGW\n");
        }
        bw.close();
    }

    static long nextLong() throws Exception {
        int sign = 0;
        long n = 0;
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

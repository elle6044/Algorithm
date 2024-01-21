import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int N=nextInt();
        int M=nextInt();
        Set<Integer> set=new TreeSet<>();
        for(int i=0;i<N;i++){
            set.add(nextInt());
        }

        for(int i=0;i<M;i++){
            set.remove(nextInt());
        }

        bw.write(set.size()+"\n");
        for (Integer i : set) {
            bw.write(i+" ");
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

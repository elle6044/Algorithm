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

        Set<Integer> set=new TreeSet<>();
        for(int i=N;i<=M;i++){
            if((i%2==0&&i!=2)||i==1){
                continue;
            }
            set.add(i);
        }

        for(int i=3;i<=M/2;i++){
            for(int j=2;j<M/i+1;j++){
                set.remove(i*j);
            }
        }

        for (Integer i : set) {
            System.out.println(i);
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

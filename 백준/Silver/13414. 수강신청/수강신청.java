import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int M=nextInt();
        int N=nextInt();

        Set<String> set=new LinkedHashSet<>();

        for(int i=0;i<N;i++){
            String input=br.readLine();
            set.remove(input);
            set.add(input);
        }

        Iterator<String> iterator=set.iterator();
        for(int i=0;i<M;i++){
            if(iterator.hasNext()){
                bw.write(iterator.next()+"\n");
            }
            else{
                break;
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

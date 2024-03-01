import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[] map={1,5,10,50};

    public static void main(String[] args) throws IOException {
        N=Integer.parseInt(br.readLine());
        back(0,0,0);
        bw.write(set.size()+"");
        bw.close();
    }

    static Set<Integer> set=new HashSet<>();
    private static void back(int idx, int cnt, int sum) {
        if(cnt==N){
            set.add(sum);
            return;
        }

        for(int i=idx;i<4;i++){
            back(i,cnt+1,sum+map[i]);
        }
    }
}

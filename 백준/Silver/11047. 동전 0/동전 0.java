import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<Integer> coins;

    public static void main(String[] args) throws Exception {
        int n=nextInt();
        int k=nextInt();
        coins=new ArrayList<>();
        for(int i=0;i<n;i++){
            int input=nextInt();
            if(input<=k){
                coins.add(input);
            }
        }

        recursive(coins.size()-1, k, 0);

        bw.write(minCnt+"");
        bw.close();

    }

    static int minCnt;
    static boolean check=false;
    private static void recursive(int idx, int money, int cnt) {
        if (money==0){
            minCnt=cnt;
            check=true;
            return;
        }

        int nowCnt=money/coins.get(idx);
        for(int i=nowCnt;i>=0;i--){
            recursive(idx-1,money-i*coins.get(idx),cnt+i);
            if(check) return;
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

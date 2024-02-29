import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static ArrayList<Integer> map=new ArrayList<>();


    public static void main(String[] args) throws Exception {
        N=nextInt();
        for(int i=0;i<N;i++){
            map.add(nextInt());
        }
        baek(0,0);

        bw.write(answer+"");
        bw.close();
    }

    static int answer=0;
    private static void baek(int cnt, int sum) {
        if(cnt==N-2){
            answer=Math.max(answer,sum);
            return;
        }

        for(int i=1;i<map.size()-1;i++){
            int num=map.get(i-1)*map.get(i+1);
            int nowNum=map.remove(i);
            baek(cnt+1,sum+num);
            map.add(i,nowNum);
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

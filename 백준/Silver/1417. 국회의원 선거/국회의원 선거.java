import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int N=nextInt();
        PriorityQueue<Integer> pq=new PriorityQueue<>(Comparator.reverseOrder());

        int num=nextInt();
        int cnt=0;
        for(int i=0;i<N-1;i++){
            pq.add(nextInt());
        }

        if(!pq.isEmpty()){
            while(num<=pq.peek()){
                num++;
                pq.offer(pq.poll()-1);
                cnt++;
            }
        }

        bw.write(cnt+"");
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

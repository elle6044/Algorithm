import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int N=nextInt();
        Queue<Integer> q=new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<N;i++){
            int type=nextInt();
            if(type==0){
                if(q.isEmpty()){
                    bw.write("-1\n");
                }
                else{
                    bw.write(q.poll()+"\n");
                }
            }
            else{
                for(int j=0;j<type;j++){
                    q.offer(nextInt());
                }
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

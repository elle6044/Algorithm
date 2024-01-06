import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int N=nextInt();
        Queue<Integer> queue=new ArrayDeque<>(N);

        while(true){
            int input=nextInt();
            if(input==-1) break;

            if(input==0){
                queue.poll();
            }

            else{
                if(queue.size()==N){
                    continue;
                }
                queue.offer(input);
            }
        }

        if(queue.size()==0){
            bw.write("empty");
        }
        else{
            for (Integer output : queue) {
                bw.write(output+" ");
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

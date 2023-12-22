import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N=Integer.parseInt(br.readLine());
        Queue<Integer> queue=new ArrayDeque<>();
        for(int i=1;i<=N;i++){
            queue.offer(i);
        }

        int cnt=1;
        while(!queue.isEmpty()){
            if(cnt%2==1){
                bw.write(queue.poll()+" ");
            }
            else{
                queue.offer(queue.poll());
            }
            cnt++;
        }

        bw.close();
    }
}

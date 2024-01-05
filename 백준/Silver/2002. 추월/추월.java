import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N=Integer.parseInt(br.readLine());
        Queue<String> q=new ArrayDeque<>();
        for(int i=0;i<N;i++){
            q.offer(br.readLine());
        }

        int cnt=0;
        for(int i=0;i<N;i++){
            String input=br.readLine();
            if(!q.peek().equals(input)){
                cnt++;
                q.remove(input);
            }
            else{
                q.poll();
            }
        }

        bw.write(cnt+"");
        bw.close();
    }
}

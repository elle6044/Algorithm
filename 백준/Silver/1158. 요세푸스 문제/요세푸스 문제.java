import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static int N,K;
    static Queue<Integer> q;

    public static void main(String[] args) throws Exception {
        N=nextInt();
        K=nextInt();

        q=new ArrayDeque<>(N);
        for(int i=1;i<=N;i++){
            q.offer(i);
        }

        int cnt=1;
        bw.write("<");
        while(!q.isEmpty()){
            int num=q.poll();
            if(cnt%K!=0){
                q.offer(num);
            }
            else{
                if(q.isEmpty()){
                    bw.write(num+">");
                }
                else{
                    bw.write(num+", ");
                }
            }
            cnt++;
        }

        bw.close();
    }

    static int nextInt() throws Exception {
        int sign=0;
        int n=0;
        int c;
        while((c=System.in.read())<=32);
        if(c==45){
            sign=1;
            c=System.in.read();
        }
        do n=(n<<3)+(n<<1)+(c&15);
        while((c=System.in.read())>47&&c<58);
        return sign==0?n:~n+1;
    }
}

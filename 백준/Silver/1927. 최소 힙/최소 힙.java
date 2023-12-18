import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static PriorityQueue<Integer> pq=new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        N=nextInt();

        for(int i=0;i<N;i++){
            int input=nextInt();
            if(input==0){
                if(pq.isEmpty()){
                    bw.write("0\n");
                }
                else{
                    bw.write(pq.poll()+"\n");
                }
            }
            else{
                pq.offer(input);
            }
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

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static int N,M;
    static HashSet<Integer> hashSet=new HashSet<>();

    public static void main(String[] args) throws Exception {
        N=nextInt();
        M=nextInt();

        for(int i=0;i<N;i++){
            hashSet.add(nextInt());
        }

        int cnt=N;
        for(int i=0;i<M;i++){
            if(hashSet.contains(nextInt())){
                cnt--;
            }
            else{
                cnt++;
            }
        }

        bw.write(cnt+"");
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

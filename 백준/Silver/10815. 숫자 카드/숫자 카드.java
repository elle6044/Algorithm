import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static int N,M;
    static int[] array=new int[20000001];

    public static void main(String[] args) throws Exception {
        N=nextInt();
        for(int i=0;i<N;i++){
            array[nextInt()+10000000]++;
        }

        StringBuilder sb=new StringBuilder();
        M=nextInt();
        for(int i=0;i<M;i++){
            if(array[nextInt()+10000000]!=0){
                sb.append("1 ");
            }
            else{
                sb.append("0 ");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        bw.write(sb.toString());
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

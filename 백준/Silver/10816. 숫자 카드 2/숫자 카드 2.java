import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static int N,M;
    static HashMap<Integer,Integer> map=new HashMap<>();

    public static void main(String[] args) throws Exception {
        N=nextInt();
        for(int i=0;i<N;i++){
            int insert=nextInt();
            if(!map.containsKey(insert)){
                map.put(insert,1);
            }
            else{
                map.put(insert, map.get(insert)+1);
            }
        }

        M=nextInt();
        for(int i=0;i<M;i++){
            int insert=nextInt();
            if(map.containsKey(insert)){
                bw.write(map.get(insert)+" ");
            }
            else{
                bw.write("0 ");
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

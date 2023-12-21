import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        long N=nextLong();
        Map<Long, Integer> map=new HashMap<>();

        int maxCnt=0;
        Long maxNum=Long.MAX_VALUE;
        for(int i=0;i<N;i++){
            Long input=nextLong();
            int newCnt=map.getOrDefault(input,0)+1;
            map.put(input,newCnt);

            if(maxCnt<newCnt){
                maxCnt=newCnt;
                maxNum=input;
            }
            else if(maxCnt==newCnt&&maxNum>input){
                maxCnt=newCnt;
                maxNum=input;
            }
        }

        bw.write(maxNum+"");
        bw.close();
    }

    static long nextLong() throws Exception {
        int sign=0;
        long n=0;
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

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int T=nextInt();
        for(int t=0;t<T;t++){
            int N=nextInt();
            int[] A=new int[N];
            for(int i=0;i<N;i++){
                A[i]=nextInt();
            }
            int M=nextInt();
            int[] B=new int[M];
            for(int i=0;i<M;i++){
                B[i]=nextInt();
            }
            int K=nextInt();
            int[] C=new int[K];
            for(int i=0;i<K;i++){
                C[i]=nextInt();
            }

            Set<Integer> set=new HashSet<>();
            for(int n=0;n<N;n++){
                for(int m=0;m<M;m++){
                    for(int k=0;k<K;k++){
                        int num=A[n]+B[m]+C[k];
                        if(!set.contains(num)&&isTrue(num)){
                            set.add(num);
                        }
                    }
                }
            }

            bw.write(set.size()+"\n");
        }
        bw.close();
    }

    private static boolean isTrue(int num) {
        while(num>0){
            int now=num%10;
            if(now==0||now % 5 != 0 && now % 8 != 0){
                return false;
            }
            num/=10;
        }
        return true;
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

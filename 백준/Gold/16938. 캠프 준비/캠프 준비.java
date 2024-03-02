import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    static int N,L,R,X;
    static int[] map;
    static boolean[] v;

    public static void main(String[] args) throws Exception {
        N=nextInt();
        L=nextInt();
        R=nextInt();
        X=nextInt();
        map=new int[N];
        v=new boolean[N];
        for(int i=0;i<N;i++){
            map[i]=nextInt();
        }
        Arrays.sort(map);

        for(int i=2;i<=N;i++){
            for(int j=0;j<=N-i;j++){
                back(i-1,j,j+1,map[j]);
            }
        }

        bw.write(answer+"");
        bw.close();
    }

    static int answer=0;
    private static void back(int cnt, int startIdx, int idx, int sum) {
        if(cnt==0){
            if(sum>=L&&sum<=R&&map[idx-1]-map[startIdx]>=X){
//                System.out.println("sum "+sum);
                answer++;
            }
            return;
        }

        if(idx<N){
//            System.out.println(startIdx+" "+idx+" "+(sum+map[idx]));
            back(cnt-1,startIdx,idx+1,sum+map[idx]);
            back(cnt,startIdx,idx+1,sum);
        }

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

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static int[][] taste;
    static int[] array;
    static boolean[] v;

    public static void main(String[] args) throws Exception {
        N=nextInt();
        taste=new int[N][2];
        for(int i=0;i<N;i++){
            taste[i][0]=nextInt();
            taste[i][1]=nextInt();
        }

        for(int i=1;i<=N;i++){
            array=new int[i];
            v=new boolean[N];
            back(i,0);
        }

        bw.write(min+"");
        bw.close();
    }

    static int min=Integer.MAX_VALUE;
    private static void back(int cnt, int idx) {
        if(cnt==0){
            int taste0=taste[array[0]][0];
            int taste1=taste[array[0]][1];
            for(int i=1;i<array.length;i++){
                taste0*=taste[array[i]][0];
                taste1+=taste[array[i]][1];
            }
            min=Math.min(min, Math.abs(taste0-taste1));
            return;
        }

        for(int i=idx;i<N;i++){
            if(!v[i]){
                array[cnt-1]=i;
                v[i]=true;
                back(cnt-1,i);
                v[i]=false;
            }
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

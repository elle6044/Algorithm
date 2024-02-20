import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N,M;

    static int[] array;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        array=new int[M];
        v=new boolean[N];

        back(0);

        bw.close();
    }

    private static void back(int cnt) throws IOException {
        if(cnt==M){
            for (int i : array) {
                bw.write(i+" ");
            }
            bw.write("\n");
            return;
        }

        for(int i=0;i<N;i++){
            if(v[i]) continue;

            array[cnt]=i+1;
            v[i]=true;
            back(cnt+1);
            v[i]=false;
        }
    }
}

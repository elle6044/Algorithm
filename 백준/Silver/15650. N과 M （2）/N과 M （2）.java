import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N,M;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        v=new boolean[N];
        back(0,0);

        bw.close();
    }

    private static void back(int cnt, int idx) throws IOException {
        if(cnt==M){
            for(int i=0;i<N;i++){
                if(v[i]){
                    bw.write((i+1)+" ");
                }
            }
            bw.write("\n");
            return;
        }

        for(int i=idx;i<N;i++){
            if(!v[i]){
                v[i]=true;
                back(cnt+1, i);
                v[i]=false;
            }
        }
    }
}

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N,M;
    static HashSet<String> hashSet=new HashSet<>();

    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            hashSet.add(br.readLine());
        }

        int cnt=0;
        for(int i=0;i<M;i++){
            if(hashSet.contains(br.readLine())) cnt++;
        }

        bw.write(cnt+"");
        bw.close();
    }
}

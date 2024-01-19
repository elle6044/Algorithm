import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        Set<String> set=new HashSet<>();

        for(int i=0;i<N;i++){
            set.add(br.readLine());
        }

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine(),",");
            while(st.hasMoreTokens()){
                String input=st.nextToken();
                set.remove(input);
            }
            bw.write(set.size()+"\n");
        }
        bw.close();
    }
}

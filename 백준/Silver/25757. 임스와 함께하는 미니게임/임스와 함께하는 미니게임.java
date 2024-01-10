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
        char type=st.nextToken().charAt(0);
        int num=type=='Y'?1:type=='F'?2:3;
        Set<String> set=new HashSet<>();

        for(int i=0;i<N;i++){
            set.add(br.readLine());
        }

        bw.write(set.size()/num+"");
        bw.close();
    }
}

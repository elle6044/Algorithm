import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N=Integer.parseInt(br.readLine());
        HashSet<Integer> hashSet=new HashSet<>();
        st=new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            hashSet.add(Integer.parseInt(st.nextToken()));
        }

        int M=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            if(hashSet.contains(Integer.parseInt(st.nextToken()))){
                bw.write("1\n");
            }
            else{
                bw.write("0\n");
            }
        }

        bw.close();
    }
}

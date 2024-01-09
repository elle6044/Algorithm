import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T=Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++){
            st=new StringTokenizer(br.readLine());
            ArrayList<String> array=new ArrayList<>();

            while(st.hasMoreTokens()){
                array.add(st.nextToken());
            }

            Set<String> set=new HashSet<>();
            while(true){
                st=new StringTokenizer(br.readLine());
                st.nextToken();
                st.nextToken();
                String minus=st.nextToken();
                if(st.hasMoreTokens()){
                    break;
                }
                set.add(minus);
            }

            for(String output:array){
                if(set.contains(output)){
                    continue;
                }
                bw.write(output+" ");
            }
        }
        bw.close();

        bw.close();

    }
}

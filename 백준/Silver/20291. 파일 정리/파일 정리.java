import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N=Integer.parseInt(br.readLine());
        Map<String, Integer> map=new TreeMap<>();
        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine(),".");
            st.nextToken();
            String input=st.nextToken();
            map.put(input,map.getOrDefault(input,0)+1);
        }

        for(String key: map.keySet()){
            bw.write(key+" "+map.get(key)+"\n");
        }

        bw.close();
    }
}

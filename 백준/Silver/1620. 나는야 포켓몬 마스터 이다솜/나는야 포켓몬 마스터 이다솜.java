import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        Map<String, Integer> map1=new HashMap<>(N);
        Map<Integer, String> map2=new HashMap<>(N);
        for(int i=1;i<=N;i++){
            String input= br.readLine();
            map1.put(input, i);
            map2.put(i, input);
        }

        for(int i=0;i<M;i++){
            String input=br.readLine();
            if(input.charAt(0)>='0'&&input.charAt(0)<='9'){
                bw.write(map2.get(Integer.parseInt(input))+"\n");
            }
            else{
                bw.write(map1.get(input)+"\n");
            }
        }
        bw.close();
    }
}

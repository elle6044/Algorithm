import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N=Integer.parseInt(br.readLine());
        Map<String, Integer> map=new HashMap<>();
        for(int i=0;i<N;i++){
            String input=br.readLine();
            map.put(input, map.getOrDefault(input,0)+1);
        }
        for(int i=0;i<N-1;i++){
            String input=br.readLine();
            map.put(input,map.get(input)-1);
        }

        for(String output:map.keySet()){
            if(map.get(output)>0){
                bw.write(output+"\n");
            }
        }

        bw.close();
    }
}

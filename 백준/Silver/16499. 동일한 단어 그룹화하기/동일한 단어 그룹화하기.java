import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Set<Map<Character,Integer>> set=new HashSet<>();
        int N=Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            String input=br.readLine();
            Map<Character,Integer> map=new HashMap<>();
            for(int j=0;j<input.length();j++){
                map.put(input.charAt(j),map.getOrDefault(input.charAt(j),0)+1);
            }

            set.add(map);
        }
        bw.write(set.size()+"");
        bw.close();
    }
}

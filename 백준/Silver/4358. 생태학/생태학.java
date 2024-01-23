import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Map<String, Integer> map=new TreeMap<>();
        long cnt=0;
        String input;
        while((input=br.readLine())!=null&&!input.isEmpty()){
            map.put(input, map.getOrDefault(input,0)+1);
            cnt++;
        }

        for (String tree : map.keySet()) {
            double percentage = (double) map.get(tree) / cnt * 100;
            bw.write(String.format("%s %.4f\n", tree, percentage));
        }

        bw.close();
    }
}

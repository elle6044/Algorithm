import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        Map<String, Integer> map=new LinkedHashMap<>();
        map.put("Re",0);
        map.put("Pt",0);
        map.put("Cc",0);
        map.put("Ea",0);
        map.put("Tb",0);
        map.put("Cm",0);
        map.put("Ex",0);
        String input;
        int cnt=0;
        while((input=br.readLine())!=null&&!input.isEmpty()){
            st=new StringTokenizer(input);
            while(st.hasMoreTokens()){
                String work=st.nextToken();
                if(map.containsKey(work)){
                    map.put(work, map.getOrDefault(work,0)+1);
                }
                cnt++;

            }
        }

        for (String work : map.keySet()) {
            double percentage = (double) map.get(work) / cnt;
            bw.write(String.format("%s %d %.2f\n", work, map.get(work), percentage));
        }
        bw.write("Total "+cnt+" 1.00");
        bw.close();
    }
}

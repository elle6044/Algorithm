import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static Map<String,Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {

        map.put("A+",45);
        map.put("A0",40);
        map.put("B+",35);
        map.put("B0",30);
        map.put("C+",25);
        map.put("C0",20);
        map.put("D+",15);
        map.put("D0",10);
        map.put("F",0);

        int sum=0;
        int cnt=0;

        for(int i=0;i<20;i++){
            st=new StringTokenizer(br.readLine());
            st.nextToken();

            int score=(int)Double.parseDouble(st.nextToken())*10;
            String input= st.nextToken();
            if(input.equals("P")) continue;

            int type=map.get(input);

            cnt+=score;
            sum+=score*type;
        }

        bw.write(((double)sum/cnt)/10+"");
        bw.close();
    }
}

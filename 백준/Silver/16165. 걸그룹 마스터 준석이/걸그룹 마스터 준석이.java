import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        Map<String, String> map=new TreeMap<>();

        for(int i=0;i<N;i++){
            String group=br.readLine();
            int cnt=Integer.parseInt(br.readLine());
            for(int j=0;j<cnt;j++){
                String member=br.readLine();
                map.put(member,group);
            }
        }

        for(int i=0;i<M;i++){
            String quiz=br.readLine();
            int type=Integer.parseInt(br.readLine());

            if(type==0){
                for (String member : map.keySet()) {
                    if(map.get(member).equals(quiz)){
                        bw.write(member+"\n");
                    }
                }
            }
            else{
                bw.write(map.get(quiz)+"\n");
            }
        }

        bw.close();
    }

    static int nextInt() throws Exception {
        int sign = 0;
        int n = 0;
        int c;
        while ((c = System.in.read()) <= 32);
        if(c == 45) {
            sign = 1;
            c = System.in.read();
        }
        do n = (n << 3) + (n << 1) + (c & 15);
        while ((c = System.in.read()) > 47 && c < 58);
        return sign == 0 ? n : ~n + 1;
    }

}

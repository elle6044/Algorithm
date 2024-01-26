import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        String inputA=st.nextToken();
        String inputB=st.nextToken();

        int minCnt=Integer.MAX_VALUE;
        for(int i=0;i<=inputB.length()-inputA.length();i++){
            String inputB2=inputB.substring(i);
            int cnt=0;
            for(int j=0;j<inputA.length();j++){
                if(inputA.charAt(j)!=inputB2.charAt(j)){
                    cnt++;
                }
            }
            minCnt=Math.min(minCnt,cnt);
        }

        bw.write(minCnt+"");
        bw.close();
    }
}

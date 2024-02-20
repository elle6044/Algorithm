import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();

    static int N,M;
    static byte[] array;

    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        array=new byte[M];

        back(0);

        bw.write(sb.toString());
        bw.close();
    }

    private static void back(int cnt) throws IOException {
        if(cnt==M){
            for (int i : array) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(byte i=1;i<=N;i++){
            array[cnt]=i;
            back(cnt+1);
        }
    }
}

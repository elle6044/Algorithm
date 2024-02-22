import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N,M;
    static char[] word;
    static char[] array;

    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        M=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());
        String input=br.readLine();
        word=new char[N];
        for(int i=0;i<N;i++){
            word[i]=input.charAt(i*2);
        }
        Arrays.sort(word);

        array=new char[M];

        back(0,0);

        bw.write(sb.toString());
        bw.close();
    }

    static StringBuilder sb=new StringBuilder();
    private static void back(int cnt, int idx) {
        if(cnt==M){
            int moCnt=0;
            for (char c : array) {
                if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
                    moCnt++;
                }
            }
            if(moCnt>=1&&M-moCnt>=2){
                for (char c : array) {
                    sb.append(c);
                }
                sb.append("\n");
            }

            return;
        }

        for(int i=idx;i<N;i++){
            array[cnt]=word[i];
            back(cnt+1,i+1);
        }
    }
}

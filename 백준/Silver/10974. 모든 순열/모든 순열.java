import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static int[] array;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        N=Integer.parseInt(br.readLine());
        array=new int[N];
        v=new boolean[N];
        back(0);

        bw.write(sb.toString());
        bw.close();
    }

    static StringBuilder sb=new StringBuilder();
    private static void back(int cnt) {
        if(cnt==N){
            for (int i : array) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0;i<N;i++){
            if(!v[i]){
                array[cnt]=i+1;
                v[i]=true;
                back(cnt+1);
                v[i]=false;
            }
        }
    }
}

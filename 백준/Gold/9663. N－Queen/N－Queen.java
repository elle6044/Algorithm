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
        array=new int[N+1];
        v=new boolean[N+1];

        back(1);

        bw.write(answer+"");
        bw.close();
    }

    static int answer=0;
    private static void back(int cnt) {
        if(cnt==N+1){
            answer++;
            return;
        }

        L:for(int i=1;i<=N;i++){
            if(!v[i]){
                array[cnt]=i;

                for(int j=1;j<=cnt;j++){
                    if(j==cnt) continue;

                    if(Math.abs(array[cnt]-array[j])==Math.abs(cnt-j)){
                        array[cnt]=0;
                        continue L;
                    }
                }

                v[i]=true;
                back(cnt+1);
                v[i]=false;
            }



        }
    }
}

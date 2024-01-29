import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        char[] ant1=new char[N+M];
        char[] ant2=new char[N+M];

        String input1=br.readLine();
        for(int i=0;i<N;i++){
            ant1[N-i-1]=input1.charAt(i);
        }

        String input2=br.readLine();
        for(int i=0;i<M;i++){
            ant2[N+i]=input2.charAt(i);
        }

        int T=Integer.parseInt(br.readLine());
        for (int t=1;t<=T;t++){
            for(int n=0;n<N+M-1;n++){
                if(ant1[n]!=0&&ant1[n+1]==0){
                    ant1[n+1]=ant1[n];
                    ant1[n]=0;
                    n++;
                }
            }

            for(int m=N+M-1;m>0;m--){
                if(ant2[m]!=0&&ant2[m-1]==0){
                    ant2[m-1]=ant2[m];
                    ant2[m]=0;
                    m--;
                }
            }
        }

        for(int i=0;i<N+M;i++){
            if(ant1[i]!=0){
                bw.write(ant1[i]);
            }
            if(ant2[i]!=0){
                bw.write(ant2[i]);
            }
        }
        bw.close();
    }
}

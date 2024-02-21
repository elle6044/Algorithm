import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    static int K,N;
    static char[] sign;

    static boolean[] v=new boolean[10];
    static int[] array;


    public static void main(String[] args) throws IOException {
        K=Integer.parseInt(br.readLine());
        N=K+1;
        sign=new char[K];
        String input=br.readLine();
        for(int i=0;i<K;i++){
            sign[i]=input.charAt(i*2);
        }

        array=new int[N];

        for(int i=0;i<10;i++){
            array[0]=i;
            v[i]=true;
            back(1);
            v[i]=false;
        }

        for (int i : max) {
            bw.write(i+"");
        }
        bw.write("\n");
        for (int i : min) {
            bw.write(i+"");
        }

        bw.close();

    }

    static int[] min;
    static int[] max;
    private static void back(int cnt) {
        if(cnt==N){

            if(min==null){
                min=Arrays.copyOf(array,N);
            }
            max=Arrays.copyOf(array,N);

            return;
        }

        for(int i=0;i<10;i++){
            if(!v[i]){
                if((sign[cnt-1]=='>'&&array[cnt-1]>i)
                ||(sign[cnt-1]=='<'&&array[cnt-1]<i)){
                    array[cnt]=i;
                    v[i]=true;
                    back(cnt+1);
                    v[i]=false;
                }
            }
        }
    }
}

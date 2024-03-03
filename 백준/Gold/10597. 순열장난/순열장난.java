import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    static String input;
    static int N=0;
    static int[] array;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        input=br.readLine();
        int cnt=0;
        for(int i=1;true;i++){
            if(i<10){
                cnt+=1;
            }
            else{
                cnt+=2;
            }
            if(cnt==input.length()) {
                N=i;
                break;
            }
        }

        array=new int[N+1];
        v=new boolean[N+1];

        back(0,0);


    }

    static boolean check=false;
    private static void back(int cnt, int idx) throws IOException {
        if(cnt==N){
            for(int i=0;i<N;i++){
                bw.write(array[i]+" ");
            }
            bw.close();
            check=true;
            return;
        }
        if(idx==input.length()) return;

        int oneNum=Character.getNumericValue(input.charAt(idx));
        if(oneNum==0) return;

        if(!v[oneNum]){
            v[oneNum]=true;
            array[cnt]=oneNum;
            back(cnt+1,idx+1);
            v[oneNum]=false;
            array[cnt]=0;
        }
        if(check) return;

        if(idx<input.length()-1){
            int twoNum=oneNum*10+Character.getNumericValue(input.charAt(idx+1));
            if(twoNum<=N&&!v[twoNum]){
                v[twoNum]=true;
                array[cnt]=twoNum;
                back(cnt+1,idx+2);
                v[twoNum]=false;
                array[cnt]=0;
            }
        }
        if(check) return;
    }
}

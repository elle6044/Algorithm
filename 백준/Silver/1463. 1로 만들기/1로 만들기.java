import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] array;

    public static void main(String[] args) throws IOException {
        int N=Integer.parseInt(br.readLine());
        array=new int[N+1];
        for(int i=1;i<=N/3;i++){
            array[i*3]=i;
        }

        for(int i=2;i<=N;i++){
            array[i]=array[i-1]+1;
            if(i%2==0){
                array[i]=Math.min(array[i],array[i/2]+1);
            }
            if(i%3==0){
                array[i]=Math.min(array[i],array[i/3]+1);
            }
        }

        bw.write(array[N]+"");
        bw.close();
    }
}

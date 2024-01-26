import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        int[][] array=new int[M][4];

        for(int i=0;i<N;i++){
            String input= br.readLine();
            for(int j=0;j<M;j++){
                char word=input.charAt(j);
                if(word=='A'){
                    array[j][0]++;
                }
                else if (word=='C'){
                    array[j][1]++;
                }
                else if (word=='G'){
                    array[j][2]++;
                }
                else{
                    array[j][3]++;
                }
            }
        }

        int sum=N*M;
        for(int i=0;i<M;i++){
            int maxCnt=0;
            int maxIdx=0;
            for(int j=0;j<4;j++){
                if(maxCnt<array[i][j]){
                    maxCnt=array[i][j];
                    maxIdx=j;
                }
            }
            sum-=maxCnt;
            if(maxIdx==0){
                bw.write("A");
            }
            else if (maxIdx==1){
                bw.write("C");
            }
            else if (maxIdx==2) {
                bw.write("G");
            }
            else {
                bw.write("T");
            }
        }
        bw.write("\n"+sum);
        bw.close();
    }
}

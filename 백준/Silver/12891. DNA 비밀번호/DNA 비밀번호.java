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
        String input=br.readLine();
        st=new StringTokenizer(br.readLine());
        int[] minCnt=new int[4];
        for(int i=0;i<4;i++){
            minCnt[i]=Integer.parseInt(st.nextToken());
        }

        int[] inputCnt=new int[4];
        for(int i=0;i<M;i++){
            char word=input.charAt(i);
            if(word=='A'){
                inputCnt[0]++;
            } else if (word == 'C') {
                inputCnt[1]++;
            } else if (word == 'G') {
                inputCnt[2]++;
            } else if (word == 'T') {
                inputCnt[3]++;
            }
        }

        int answer=N-M+1;
        for(int i=0;i<4;i++){
            if(inputCnt[i]<minCnt[i]){
                answer--;
                break;
            }
        }

        for(int i=0;i<N-M;i++){
            char newWord=input.charAt(M+i);
            char oldWord=input.charAt(i);

            switch (oldWord){
                case 'A':
                    inputCnt[0]--;
                    break;
                case 'C':
                    inputCnt[1]--;
                    break;
                case 'G':
                    inputCnt[2]--;
                    break;
                case 'T':
                    inputCnt[3]--;
                    break;
            }

            switch (newWord){
                case 'A':
                    inputCnt[0]++;
                    break;
                case 'C':
                    inputCnt[1]++;
                    break;
                case 'G':
                    inputCnt[2]++;
                    break;
                case 'T':
                    inputCnt[3]++;
                    break;
            }

            for(int j=0;j<4;j++){
                if(inputCnt[j]<minCnt[j]){
                    answer--;
                    break;
                }
            }
        }

        bw.write(answer+"");
        bw.close();
    }
}

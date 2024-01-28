import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int T=Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            int N=Integer.parseInt(br.readLine());
            boolean[][]map=new boolean[2][N];
            int[] whiteCnt=new int[2];

            for(int i=0;i<2;i++){
                String input=br.readLine();
                for(int j=0;j<N;j++){
                    if(input.charAt(j)=='W'){
                        map[i][j]=true;
                        whiteCnt[i]++;
                    }
                }
            }

            int answer=Math.abs(whiteCnt[0]-whiteCnt[1]);
            for(int i=0;i<answer;i++){
                if(whiteCnt[0]>whiteCnt[1]){
                    for(int j=0;j<N;j++){
                        if(map[0][j]&&!map[1][j]){
                            map[0][j]=false;
                            break;
                        }
                    }
                }
                else{
                    for(int j=0;j<N;j++){
                        if(!map[0][j]&&map[1][j]){
                            map[0][j]=true;
                            break;
                        }
                    }
                }
            }

            int switchCnt=0;
            for (int i=0;i<N;i++){
                if(map[0][i]!=map[1][i]){
                    switchCnt++;
                }
            }
            answer+=switchCnt/2;

            bw.write(answer+"\n");
        }
        bw.close();
    }
}

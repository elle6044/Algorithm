import java.io.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N=Integer.parseInt(br.readLine());
        boolean[][] map=new boolean[N][N];
        for(int i=0;i<N;i++){
            String input=br.readLine();
            for(int j=0;j<N;j++){
                map[i][j]= input.charAt(j) == '.';
            }
        }

        int rCnt=0;
        int cCnt=0;
        for(int i=0;i<N;i++){
            int rTempCnt=0;
            int cTempCnt=0;
            for(int j=0;j<N;j++){
                if(map[i][j]){
                    rTempCnt++;
                    if(rTempCnt==2){
                        rCnt++;
                    }
                }
                else{
                    rTempCnt=0;
                }
                if(map[j][i]){
                    cTempCnt++;
                    if(cTempCnt==2){
                        cCnt++;
                    }
                }
                else{
                    cTempCnt=0;
                }
            }
        }
        bw.write(rCnt+" "+cCnt);
        bw.close();
    }
}

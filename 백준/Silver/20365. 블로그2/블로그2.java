import java.io.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N=Integer.parseInt(br.readLine());
        String input=br.readLine()+" ";

        int redCnt=0;
        int blueCnt=0;
        int now=input.charAt(0);
        for(int i=1;i<=N;i++){
            char word=input.charAt(i);
            if (word!=now){
                if(now=='R'){
                    redCnt++;
                }
                else{
                    blueCnt++;
                }
                now=word;
            }
        }
        int answer=redCnt<=blueCnt?redCnt+1:blueCnt+1;
        bw.write(answer+"");
        bw.close();
    }
}

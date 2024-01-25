import java.io.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String input=br.readLine()+"2";

        int oneCnt=0;
        int zeroCnt=0;
        char last=input.charAt(0);
        for(int i=1;i<input.length();i++){
            char now=input.charAt(i);
            if(now==last){
                continue;
            }
            else{
                if(last=='0'){
                    zeroCnt++;
                }
                else{
                    oneCnt++;
                }
                last=now;
            }
        }

        bw.write(Math.min(zeroCnt, oneCnt)+"");
        bw.close();
    }
}

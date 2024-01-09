import java.io.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String input=br.readLine();

        int openCnt=0;
        int closeCnt=0;
        for(int i=0;i<input.length();i++){
            char word=input.charAt(i);
            if(word=='('){
                openCnt++;
            }
            else{
                if(openCnt==0){
                    closeCnt++;
                }
                else{
                    openCnt--;
                }
            }
        }

        bw.write(openCnt+closeCnt+"");
        bw.close();
    }


}

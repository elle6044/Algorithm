import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int T=Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            String word=br.readLine();
            int answer=0;
            for(int i=0;i<word.length();i++){
                char input=word.charAt(i);
                if(input=='('){
                    answer++;
                }
                else{
                    answer--;
                    if(answer<0){
                        break;
                    }
                }
            }

            if(answer==0){
                bw.write("YES\n");
            }
            else{
                bw.write("NO\n");
            }
        }
        bw.close();
    }
}

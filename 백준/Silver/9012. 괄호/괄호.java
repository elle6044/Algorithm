import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int T=Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            String word=br.readLine();
            Stack<Character> s=new Stack<>();
            boolean check=false;
            for(int i=0;i<word.length();i++){
                char input=word.charAt(i);
                if(input=='('){
                    s.push('(');
                }
                else{
                    if(!s.isEmpty()){
                        s.pop();
                    }
                    else{
                        check=true;
                        break;
                    }
                }
            }
            if(!s.isEmpty()){
                check=true;
            }

            if(check){
                bw.write("NO\n");
            }
            else{
                bw.write("YES\n");
            }
        }
        bw.close();
    }
}

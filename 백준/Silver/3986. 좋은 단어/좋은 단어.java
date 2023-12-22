import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N=Integer.parseInt(br.readLine());
        int cnt=0;

        L:for(int i=0;i<N;i++){
            String input=br.readLine();
            Stack<Character> stack=new Stack<>();

            for(int j=0;j<input.length();j++){
                char word=input.charAt(j);
                if(stack.isEmpty()){
                    stack.push(word);
                }
                else{
                    if(stack.peek()==word){
                        stack.pop();
                    }
                    else{
                        stack.push(word);
                    }
                }

                if(stack.size()>input.length()-1-j){
                    continue L;
                }
            }
            cnt++;
        }

        bw.write(cnt+"");
        bw.close();
    }
}

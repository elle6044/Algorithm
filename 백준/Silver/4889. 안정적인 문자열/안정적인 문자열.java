import java.io.*;
import java.util.Stack;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int t=1;
        while(true){
            String input=br.readLine();
            if(input.contains("-")){
                break;
            }

            Stack<Character> stack=new Stack<>();
            int cnt=0;

            for(int i=0;i<input.length();i++){
                char word=input.charAt(i);
                if(word=='{'){
                    stack.push(word);
                }
                else{
                    if(stack.isEmpty()){
                        cnt++;
                        stack.push('{');
                    }
                    else{
                        stack.pop();
                    }
                }
            }

            cnt+=stack.size()/2+stack.size()%2;

            bw.write(t+". "+cnt+"\n");
            t++;
        }
        bw.close();
    }
}

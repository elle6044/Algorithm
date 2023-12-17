import java.io.*;
import java.util.Stack;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        L:while(true){
            String word=br.readLine();
            if(word.length()==1&&word.equals(".")) break;

            Stack<Character> stack=new Stack<>();
            for(int i=0;i<word.length();i++){
                char input=word.charAt(i);
                if(input=='['||input=='('){
                    stack.push(input);
                }
                else if(input==']'||input==')'){
                    if(stack.isEmpty()){
                        bw.write("no\n");
                        continue L;
                    }
                    else{
                        char output=stack.pop();
                        if((input==']'&&output=='(')||input==')'&&output=='['){
                            bw.write("no\n");
                            continue L;
                        }
                    }
                }
            }

            if(!stack.isEmpty()){
                bw.write("no\n");
                continue L;
            }
            bw.write("yes\n");
        }
        bw.close();
    }
}

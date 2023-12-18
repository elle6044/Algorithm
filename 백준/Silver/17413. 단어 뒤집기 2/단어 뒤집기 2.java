import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static Stack<Character> stack=new Stack<>();

    public static void main(String[] args) throws IOException {
        StringBuilder sb=new StringBuilder();
        String input=br.readLine();

        boolean tag=false;

        for(int i=0;i<input.length();i++){
            char word=input.charAt(i);

            if(tag){
                sb.append(word);
                if(word=='>'){
                    tag=false;
                }
            }
            else{
                if(word=='<'){
                    while(!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                    tag=true;
                    sb.append(word);
                }

                else if(word==' '){
                    while(!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                    sb.append(" ");
                }
                else{
                    stack.push(word);
                }
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        bw.write(sb.toString());
        bw.close();
    }
}

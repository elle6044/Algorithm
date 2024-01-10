import java.io.*;
import java.util.Set;
import java.util.Stack;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String input=br.readLine();
        Stack<Character> stack=new Stack<>();
        int cnt=0;
        int sum=0;

        for(int i=0;i<input.length();i++){
            char word=input.charAt(i);
            if(word=='('){
                cnt++;
            }
            else{
                if(stack.peek()=='('){
                    cnt--;
                    sum+=cnt;
                }
                else{
                    cnt--;
                    sum++;
                }
            }
            stack.push(word);
        }
        bw.write(sum+"");
        bw.close();
    }
}

import java.io.*;
import java.util.Stack;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        String bomb = br.readLine();
        Stack<Character> stack=new Stack<>();

        for(int i=0;i<input.length();i++){
            stack.push(input.charAt(i));

            if(stack.size()>=bomb.length()){
                boolean isBomb=true;
                for(int j=0;j<bomb.length();j++){
                    if(stack.get(stack.size()-bomb.length()+j)!=bomb.charAt(j)){
                        isBomb=false;
                        break;
                    }
                }
                if(isBomb){
                    for(int j=0;j<bomb.length();j++){
                        stack.pop();
                    }
                }
            }
        }

        if (stack.isEmpty()){
            bw.write("FRULA");
        }
        else {
            for (Character c : stack) {
                bw.write(c);
            }
        }
        bw.close();
    }
}

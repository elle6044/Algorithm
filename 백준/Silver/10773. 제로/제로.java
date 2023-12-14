import java.io.*;
import java.util.Stack;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    static int K;
    static Stack<Integer> stack=new Stack<>();

    public static void main(String[] args) throws IOException {
        K=Integer.parseInt(br.readLine());
        int sum=0;
        for(int i=0;i<K;i++){
            int input=Integer.parseInt(br.readLine());
            if(input!=0){
                stack.push(input);
                sum+=input;
            }
            else{
                sum-=stack.pop();
            }
        }

        bw.write(sum+"");
        bw.close();
    }
}

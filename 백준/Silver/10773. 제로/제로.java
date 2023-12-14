import java.io.*;
import java.util.Stack;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    static int K;
    static Stack<Integer> stack=new Stack<>();

    public static void main(String[] args) throws Exception {
        K=nextInt();
        int sum=0;
        for(int i=0;i<K;i++){
            int input=nextInt();
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

    static int nextInt() throws Exception {
        int sign = 0;
        int n = 0;
        int c;
        while ((c = System.in.read()) <= 32);
        if(c == 45) {
            sign = 1;
            c = System.in.read();
        }
        do n = (n << 3) + (n << 1) + (c & 15);
        while ((c = System.in.read()) > 47 && c < 58);
        return sign == 0 ? n : ~n + 1;
    }
}

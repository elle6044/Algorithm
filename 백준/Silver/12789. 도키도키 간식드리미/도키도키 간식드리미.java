import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int N=nextInt();

        int cnt=1;
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<N;i++){

            int input=nextInt();
            if(cnt==input){
                cnt++;
            }
            else{
                if(stack.isEmpty()){
                    stack.add(input);
                }
                else{
                    if(cnt==stack.peek()){
                        while(!stack.isEmpty()&&cnt==stack.peek()){
                            stack.pop();
                            cnt++;
                        }
                        stack.add(input);
                    }
                    else{
                        stack.add(input);
                    }
                }
            }
        }

        while(!stack.isEmpty()){
            int output=stack.pop();
            if(cnt==output){
                cnt++;
            }
            else{
                break;
            }
        }

        if(cnt==N+1){
            bw.write("Nice");
        }
        else{
            bw.write("Sad");
        }
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

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int N=nextInt();
        int[] allTop=new int[N];
        int[] answer=new int[N];
        for(int i=0;i<N;i++){
            allTop[i]=nextInt();
        }

        Stack<Integer> stack=new Stack<>();

        for(int i=0;i<N;i++){
            while(!stack.isEmpty()&&allTop[stack.peek()]<allTop[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                answer[i]=stack.peek()+1;
            }
            stack.push(i);
        }

        for(int i:answer){
            bw.write(i+" ");
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

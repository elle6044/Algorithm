import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n=Integer.parseInt(br.readLine());
        int[] dp=new int[n+1];
        Stack[] stacks=new Stack[n+1];
        Stack<Integer> oneStack=new Stack<>();
        oneStack.push(1);
        stacks[1]=oneStack;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+1;
            Stack<Integer> stack=new Stack<>();
            stack.addAll(stacks[i-1]);
            stack.push(i);

            if(i%3==0){
                if(dp[i/3]+1<dp[i]){
                    dp[i]=dp[i/3]+1;
                    stack.clear();
                    stack.addAll(stacks[i/3]);
                    stack.push(i);
                }
            }
            if(i%2==0){
                if(dp[i/2]+1<dp[i]){
                    dp[i]=dp[i/2]+1;
                    stack.clear();
                    stack.addAll(stacks[i/2]);
                    stack.push(i);
                }
            }
            stacks[i]=stack;
        }

        bw.write(dp[n]+"\n");
        while(!stacks[n].isEmpty()){
            bw.write(stacks[n].pop()+" ");
        }
        bw.close();
    }
}

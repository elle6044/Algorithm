import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N,K;

    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        back(new Stack<Integer>(),0);

        if(!check){
            bw.write("-1");
        }
        bw.close();
    }

    static int cnt=1;
    static boolean check=false;
    private static void back(Stack<Integer> stack,int sum) throws IOException {
        if(sum>N||check){
            return;
        }

        if(sum==N){
            if(cnt==K){
                StringBuilder sb=new StringBuilder();
                for (Integer i : stack) {
                    sb.append(i).append("+");
                }
                sb.deleteCharAt(sb.length()-1);
                bw.write(sb.toString());
                check=true;
            }
            else{
                cnt++;
            }

            return;
        }



        for(int i=1;i<=3;i++){
            stack.push(i);
            back(stack,sum+i);
            stack.pop();
        }
    }
}

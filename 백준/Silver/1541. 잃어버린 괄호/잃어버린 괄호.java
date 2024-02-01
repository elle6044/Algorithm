import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String input=br.readLine();
        st=new StringTokenizer(input,"-");

        Stack<String> stack=new Stack<>();
        int answer=0;
        int cnt=0;

        while(st.hasMoreTokens()){
            StringTokenizer st2=new StringTokenizer(st.nextToken(),"+");
            int temp=0;
            while(st2.hasMoreTokens()){
                temp+=Integer.parseInt(st2.nextToken());
            }
            if(cnt==0){
                if(input.charAt(0)=='-'){
                    answer-=temp;
                }
                else{
                    answer+=temp;
                }
            }
            else{
                answer-=temp;
            }
            cnt++;
        }

        bw.write(answer+"");
        bw.close();
    }
}

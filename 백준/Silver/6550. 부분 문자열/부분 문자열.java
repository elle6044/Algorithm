import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String input="";
        while((input=br.readLine())!=null&&!input.isEmpty()){
            st=new StringTokenizer(input);
            String input1=st.nextToken();
            String input2=st.nextToken();
            Queue<Character> queue=new ArrayDeque<>();
            for(int i=0;i<input1.length();i++){
                queue.offer(input1.charAt(i));
            }

            for(int i=0;i<input2.length();i++){
                if(queue.isEmpty()) break;
                if(input2.charAt(i)==queue.peek()){
                    queue.poll();
                }
            }
            if(queue.isEmpty()){
                bw.write("Yes\n");
            }
            else{
                bw.write("No\n");
            }
        }
        bw.close();
    }
}

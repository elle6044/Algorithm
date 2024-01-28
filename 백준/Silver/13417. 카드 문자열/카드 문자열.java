import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T=Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            int N=Integer.parseInt(br.readLine());
            Deque<Character> deque=new ArrayDeque<>();
            st=new StringTokenizer(br.readLine());
            deque.offer(st.nextToken().charAt(0));

            for(int i=1;i<N;i++){
                char word=st.nextToken().charAt(0);
                if(deque.getFirst()>=word){
                    deque.offerFirst(word);
                }
                else {
                    deque.offerLast(word);
                }
            }

            for (Character c : deque) {
                bw.write(c);
            }
            bw.write("\n");
        }
        bw.close();
    }
}

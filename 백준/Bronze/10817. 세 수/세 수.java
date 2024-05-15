import java.util.*;
import java.io.*;
class Main{
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        st=new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq=new PriorityQueue();
        while(st.hasMoreTokens()){
            pq.offer(Integer.parseInt(st.nextToken()));
        }
        pq.poll();
        bw.write(pq.poll()+"");
        bw.close();
    }
}
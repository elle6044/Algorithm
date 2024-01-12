import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int T=Integer.parseInt(br.readLine());
        L:for(int t=0;t<T;t++){
            String command= br.readLine();
            int N=Integer.parseInt(br.readLine());
            Deque<Integer> deque=new ArrayDeque<>();

            String input=br.readLine();
            st=new StringTokenizer(input.substring(1,input.length()-1),",");
            while(st.hasMoreTokens()){
                deque.offer(Integer.parseInt(st.nextToken()));
            }


            boolean dir=true;
            for(int i=0;i<command.length();i++){
                if(command.charAt(i)=='R'){
                    dir= dir?false:true;
                }
                else{
                    if(deque.isEmpty()){
                        bw.write("error\n");
                        continue L;
                    }
                    else{
                        if(dir){
                            deque.pollFirst();
                        }
                        else{
                            deque.pollLast();
                        }
                    }
                }
            }

            if(dir){
                bw.write("[");
                while(!deque.isEmpty()){
                    bw.write(deque.pollFirst()+"");
                    if(!deque.isEmpty()){
                        bw.write(",");
                    }
                }
                bw.write("]\n");
            }
            else{
                bw.write("[");
                while(!deque.isEmpty()){
                    bw.write(deque.pollLast()+"");
                    if(!deque.isEmpty()){
                        bw.write(",");
                    }
                }
                bw.write("]\n");

            }
        }
        bw.close();
    }
}

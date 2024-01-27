import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine(),"*");
        String start=st.nextToken();
        String end=st.nextToken();

        for(int n=0;n<N;n++){
            String input=br.readLine();
            if(input.length()>=start.length()+end.length()){
                if(input.startsWith(start)&&input.endsWith(end)){
                    bw.write("DA\n");
                }
                else{
                    bw.write("NE\n");
                }
            }
            else{
                bw.write("NE\n");
            }
        }
        bw.close();
    }
}

import java.io.*;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main{
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N=Integer.parseInt(br.readLine());
        Set<String> set=new TreeSet<>();
        st=new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            String input=st.nextToken();
            if(input.length()>=6&&input.substring(input.length()-6).equals("Cheese")){
                set.add(input);
            }

        }

        if(set.size()>=4){
            bw.write("yummy");
        }
        else{
            bw.write("sad");
        }
        bw.close();
    }
}

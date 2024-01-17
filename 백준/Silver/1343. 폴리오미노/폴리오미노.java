import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String input=br.readLine();
        input=input.replaceAll("XXXX","AAAA");
        input=input.replaceAll("XX","BB");
        if(input.contains("X")){
            bw.write("-1");
        }
        else{
            bw.write(input);
        }
        bw.close();
    }
}

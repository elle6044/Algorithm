import java.io.*;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String input=br.readLine();
        Set<String> set=new TreeSet<>();
        for(int i=0;i<input.length();i++){
            set.add(input.substring(i));
        }

        for (String output : set) {
            bw.write(output+"\n");
        }
        bw.close();
    }
}

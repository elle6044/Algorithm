import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String input=br.readLine();
        int len=input.length();
        input=input.concat(" ");
        Set<String> set=new HashSet<>();

        for(int i=1;i<=len;i++){
            for(int j=0;j<=len-i;j++){
                String word=input.substring(j,i+j);
                set.add(word);
            }
        }

        bw.write(set.size()+"");
        bw.close();
    }
}

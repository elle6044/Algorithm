import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N=Integer.parseInt(br.readLine());
        Set<String> set=new HashSet<>();

        L:for(int i=0;i<N;i++){
            String input=br.readLine();
            String twice=input+input;

            for(int j=0;j<input.length();j++){
                String output=twice.substring(j,j+input.length());
                if (set.contains(output)){
                    continue L;
                }
            }
            set.add(input);
        }

        bw.write(set.size()+"");
        bw.close();

    }
}

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        L:while(true){
            String input=br.readLine();
            if(input.equals("*")) break;

            for(int i=1;i<input.length();i++){
                Set<String> set=new HashSet<>();
                for(int j=0;j<input.length()-i;j++){
                    String output= String.valueOf(input.charAt(j))+String.valueOf(input.charAt(i+j));
                    if(set.contains(output)){
                        bw.write(input+" is NOT surprising.\n");
                        continue L;
                    }
                    set.add(output);
                }
            }
            bw.write(input+" is surprising.\n");
        }
        bw.close();
    }
}

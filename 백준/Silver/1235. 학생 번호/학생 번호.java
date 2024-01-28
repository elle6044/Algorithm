import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N=Integer.parseInt(br.readLine());
        String[] input=new String[N];
        for(int i=0;i<N;i++){
            input[i]=br.readLine();
        }

        L:for(int i=input[0].length()-1;i>=0;i--){
            Set<String> set=new HashSet<>();
            for(int j=0;j<N;j++){
                String sub=input[j].substring(i);
                if(set.contains(sub)){
                    continue L;
                }
                set.add(sub);
            }
            bw.write((input[0].length()-i)+"");
            break;
        }
        bw.close();
    }
}

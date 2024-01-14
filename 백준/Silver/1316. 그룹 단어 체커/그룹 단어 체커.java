
import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N=Integer.parseInt(br.readLine());
        int cnt=0;
        L:for(int i=0;i<N;i++){
            String input=br.readLine();
            Set<Character> set=new HashSet<>();
            char temp=' ';
            for(int j=0;j<input.length();j++){
                char now=input.charAt(j);
                if(temp!=now){
                    if(set.contains(now)){
                        continue L;
                    }
                    temp=now;
                    set.add(now);
                }
            }
            cnt++;
        }
        bw.write(cnt+"");
        bw.close();
    }
}

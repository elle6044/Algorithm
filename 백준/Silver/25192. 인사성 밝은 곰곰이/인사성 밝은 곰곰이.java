import java.io.*;
import java.util.HashSet;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N=Integer.parseInt(br.readLine());
        HashSet<String> set=new HashSet<>();

        int cnt=0;
        for(int i=0;i<N;i++){
            String input=br.readLine();
            if(input.equals("ENTER")){
                set.clear();
                continue;
            }

            if(!set.contains(input)){
                cnt++;
                set.add(input);
            }
        }

        bw.write(cnt+"");
        bw.close();
    }
}

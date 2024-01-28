import java.io.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String target=br.readLine();
        int N=Integer.parseInt(br.readLine());

        int cnt=0;
        for(int n=0;n<N;n++){
            String input=br.readLine();
            int len=input.length();
            input+=input;
            for(int i=0;i<len;i++){
                if(input.startsWith(target, i)){
                    cnt++;
                    break;
                }
            }
        }
        bw.write(cnt+"");
        bw.close();
    }
}

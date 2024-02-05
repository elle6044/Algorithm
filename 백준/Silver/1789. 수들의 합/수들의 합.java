import java.io.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        long S=Long.parseLong(br.readLine());
        int cnt=1;
        while(S>=cnt){
            S-=cnt++;
        }
        cnt--;

        bw.write(cnt+"");
        bw.close();
    }
}

import java.io.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int X=Integer.parseInt(br.readLine());

        int len=64;
        int cnt=0;
        while(X!=0){
            if(X<len){
                len/=2;
            }
            else{
               X-=len;
               cnt++;
            }
        }
        bw.write(cnt+"");
        bw.close();
    }
}

import java.io.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N=Integer.parseInt(br.readLine());
        int cnt=0;

        while(true){
            N-=cnt;
            cnt++;
            if(N<=cnt){
                break;
            }
        }
//        System.out.println(cnt+" "+N);

        int up=0;
        int down=0;
        if(cnt%2==0){
            up=N;
            down=cnt-N+1;
        }
        else{
            up=cnt-N+1;
            down=N;
        }

        bw.write(up+"/"+down);
        bw.close();
    }
}

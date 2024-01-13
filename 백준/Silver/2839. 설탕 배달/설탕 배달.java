import java.io.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N=Integer.parseInt(br.readLine());

        int maxFive=N/5;
        int answer=-1;

        for(int i=maxFive;i>=0;i--){
            if((N-(i*5))%3==0){
                answer=i+(N-(i*5))/3;
                break;
            }
        }
        bw.write(answer+"");
        bw.close();
    }
}

import java.io.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n=Integer.parseInt(br.readLine());
        int five=n/5;
        int two=0;
        while(five>=0){
            int change=n-5*five;
            if(change%2==0){
                two=change/2;
                break;
            }
            five--;
        }
        if(five<0){
            bw.write("-1");
        }
        else{
            bw.write((five+two)+"");
        }

        bw.close();
    }
}

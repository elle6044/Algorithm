import java.io.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String input=br.readLine();
        int sum=input.length()*Integer.parseInt(input);

        for(int i=1;i<input.length();i++){
            sum-=Math.pow(10,i)-1;
        }
        bw.write(sum+"");
        bw.close();
    }
}

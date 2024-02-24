import java.io.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N=Integer.parseInt(br.readLine());
        String input=br.readLine();
        int answer=0;
        for(int i=0;i<N;i++){
            answer+=Character.getNumericValue(input.charAt(i));
        }

        bw.write(answer+"");
        bw.close();

    }
}

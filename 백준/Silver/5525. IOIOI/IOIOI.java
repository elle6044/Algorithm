import java.io.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N=Integer.parseInt(br.readLine());
        int M=Integer.parseInt(br.readLine());
        String input=br.readLine()+" ";

        String word="I";
        for(int i=0;i<N;i++){
            word+="OI";
        }

        int cnt=0;
        for(int i=0;i<=input.length()-1-word.length();i++){
            if(word.equals(input.substring(i,i+word.length()))){
                cnt++;
            }
        }

        bw.write(cnt+"");
        bw.close();
    }
}

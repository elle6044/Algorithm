import java.io.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String input=br.readLine()+" ";
        String word=br.readLine();
        int cnt=0;
        for(int i=0;i<=input.length()-1-word.length();i++){
            if(word.equals(input.substring(i,i+word.length()))){
                cnt++;
                i+=word.length()-1;
            }
        }
        bw.write(cnt+"");
        bw.close();
    }
}

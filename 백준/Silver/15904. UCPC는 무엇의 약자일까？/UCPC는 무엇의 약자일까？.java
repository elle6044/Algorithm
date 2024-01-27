import java.io.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String input=br.readLine();
        char[] word={'U','C','P','C'};
        int idx=0;

        for(int i=0;i<input.length();i++){
            if(idx<=3&&input.charAt(i)==word[idx]){
                idx++;
            }
        }

        if(idx==4){
            bw.write("I love UCPC");
        }
        else{
            bw.write("I hate UCPC");
        }
        bw.close();
    }
}

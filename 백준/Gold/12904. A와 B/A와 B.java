import java.io.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        StringBuilder S=new StringBuilder(br.readLine());
        StringBuilder T=new StringBuilder(br.readLine());

        while (T.length()>S.length()){
            if(T.charAt(T.length()-1)=='B'){
                T.deleteCharAt(T.length()-1);
                T=T.reverse();
            } else if (T.charAt(T.length()-1)=='A') {
                T.deleteCharAt(T.length()-1);
            }
        }
        if(T.toString().equals(S.toString())){
            bw.write("1");
        }
        else{
            bw.write("0");
        }
        bw.close();
    }
}

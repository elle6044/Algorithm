import java.io.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    static String S;
    static String T;
    public static void main(String[] args) throws IOException {
        S=br.readLine();
        T=br.readLine();

        recursive(S);

        bw.write(isSame+"");
        bw.close();
    }

    static int isSame=0;
    private static void recursive(String s) {
        if(s.length()==T.length()){
            if (s.equals(T)){
                isSame=1;
            }
            return;
        }
        String next=new StringBuilder(s).reverse()+"B";
        if(T.contains(next)||T.contains(new StringBuilder(next).reverse())){
            recursive(next);
        }
        next=s+"A";
        if(T.contains(next)||T.contains(new StringBuilder(next).reverse())){
            recursive(next);
        }
    }
}

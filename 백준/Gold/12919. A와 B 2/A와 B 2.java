import java.io.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuffer s;
    static StringBuffer t;

    public static void main(String[] args) throws IOException {
        s=new StringBuffer(br.readLine());
        t=new StringBuffer(br.readLine());

        recursive(t);

        bw.write(isTrue+"");
        bw.close();
    }

    static int isTrue=0;
    private static void recursive(StringBuffer t) {
        if(s.length()==t.length()){
            if(s.toString().equals(t.toString())){
                isTrue=1;
            }
            return;
        }

        if(t.charAt(t.length()-1)=='A'){
            StringBuffer t2=new StringBuffer(t);
            recursive(t2.deleteCharAt(t2.length()-1));
//            t.append('A');
        }
        if(t.charAt(0)=='B'){
            StringBuffer t2=new StringBuffer(t);
            t2.reverse();
            recursive(t2.deleteCharAt(t2.length()-1));
        }
    }
}

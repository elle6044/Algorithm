import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N;
    static char[] map;
    static boolean[] v;
    static char[] array;
    static int k;

    public static void main(String[] args) throws IOException {
        String input="";
        while((input=br.readLine())!=null&&!input.isEmpty()){
            st=new StringTokenizer(input);
            String word=st.nextToken();
            N=word.length();
            map=new char[word.length()];
            v=new boolean[word.length()];
            array=new char[word.length()];
            k=Integer.parseInt(st.nextToken());
            for(int i=0;i<word.length();i++){
                map[i]=input.charAt(i);
            }
            Arrays.sort(map);

            back(0);

            bw.write(input+" = ");
            if(k==0){
                for (char c : array) {
                    bw.write(c);
                }
            }
            else{
                bw.write("No permutation");
            }
            bw.write("\n");
        }
        bw.close();
    }

    private static void back(int cnt) {
        if(k==0) return;
        if(cnt==N){
            k--;
            return;
        }

        for(int i=0;i<map.length;i++){
            if(!v[i]){
                v[i]=true;
                array[cnt]=map[i];
                back(cnt+1);
                if(k==0) return;
                v[i]=false;
            }
        }
    }
}

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    static String input;
    static char[] map;
    static boolean[] v;
    static char[] array;
    public static void main(String[] args) throws IOException {
        input=br.readLine();
        map=new char[input.length()];
        for(int i=0;i<input.length();i++){
            map[i]=input.charAt(i);
        }
        Arrays.sort(map);
        v=new boolean[input.length()];
        array=new char[input.length()];

        back(0);

        bw.write(answer+"");
        bw.close();
    }

    static int answer=0;
    private static void back(int cnt) {
        if(cnt==input.length()){
            for(int i=1;i<input.length();i++){
                if(array[i-1]==array[i]){
                    return;
                }
            }

            answer++;
            return;
        }

        char temp=' ';
        for(int i=0;i<input.length();i++){
            if(temp==map[i]) continue;
            if(!v[i]){
                array[cnt]=map[i];
                v[i]=true;
                temp=map[i];
                back(cnt+1);
                v[i]=false;
            }
        }
    }
}

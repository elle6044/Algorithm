import java.io.*;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static String input;
    static int[] wordCnt;

    static Set<String> set=new TreeSet<>();

    public static void main(String[] args) throws IOException {
        int T=Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            wordCnt=new int[26];

            input=br.readLine();
            for(int i=0;i<input.length();i++){
                wordCnt[input.charAt(i)-97]++;
            }

            StringBuilder answer=new StringBuilder();
            recursive(answer);
        }
        bw.close();
    }

    private static void recursive(StringBuilder answer) throws IOException {
        if(answer.length()==input.length()){
            bw.write(answer+"\n");
        }

        for(int i=0;i<wordCnt.length;i++){
            if(wordCnt[i]!=0){
                wordCnt[i]--;
                recursive(answer.append((char)(i+97)));
                wordCnt[i]++;
                answer.deleteCharAt(answer.length()-1);
            }
        }
    }
}

import java.io.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String input=br.readLine();
        Map<Character,Integer> map=new TreeMap<>();
        for(int i=0;i<input.length();i++){
            char word=input.charAt(i);
            map.put(word,map.getOrDefault(word,0)+1);
        }

        String answer="";
        int cnt=0;
        char mid=' ';
        for (Character word : map.keySet()) {
            int wordCnt=map.get(word);
            if(wordCnt%2==1){
                cnt++;
                mid=word;

                if(wordCnt>=3){
                    for(int i=0;i<wordCnt/2;i++){
                        answer+=word;
                    }
                }

                if(cnt>=2) {
                    break;
                }
            }
            else{
                for(int i=0;i<wordCnt/2;i++){
                    answer+=word;
                }
            }
        }

        if(cnt>=2){
            answer="I'm Sorry Hansoo";
        }
        else{
            if(cnt==1){
                answer+=mid+new StringBuilder(answer).reverse().toString();
            }
            else{
                answer+=new StringBuilder(answer).reverse().toString();
            }
        }

        bw.write(answer);
        bw.close();
    }
}

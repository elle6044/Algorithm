import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N=Integer.parseInt(br.readLine());
        Map<Character,Integer> map=new HashMap<>();
        String first=br.readLine();
        for(int i=0;i<first.length();i++){
            map.put(first.charAt(i),map.getOrDefault(first.charAt(i),0)+1);
        }

        int answer=0;
        for(int n=1;n<N;n++){
            String input=br.readLine();
            Map<Character,Integer> wordMap=new HashMap<>();
            wordMap.putAll(map);
            for(int i=0;i<input.length();i++){
                char word=input.charAt(i);
                wordMap.put(word, wordMap.getOrDefault(word,0)-1);
            }
            int plusCnt=0;
            int minusCnt=0;
            for (Character c : wordMap.keySet()) {
                int output=wordMap.get(c);
                if(output>0){
                    plusCnt+=output;
                }
                else{
                    minusCnt+=output;
                }
            }
//            System.out.println(plusCnt+" "+minusCnt);

            if(Math.abs(plusCnt+minusCnt)<=1&&plusCnt-minusCnt<=2){
                answer++;
            }
        }
        bw.write(answer+"");
        bw.close();
    }
}

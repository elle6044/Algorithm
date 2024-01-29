import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int T=Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            String input=br.readLine();
            Map<Character, Integer> map=new HashMap<>();
            String answer="OK";
            for(int i=0;i<input.length();i++){
                char word=input.charAt(i);
                map.put(word,map.getOrDefault(word,0)+1);
                int cnt=map.get(word);
                if(cnt%3==0){
                    if(i==input.length()-1){
                        answer="FAKE";
                        break;
                    }
                    else{
                        if(word!=input.charAt(i+1)){
                            answer="FAKE";
                            break;
                        }
                        else{
                            i++;
                        }
                    }
                }
            }
            bw.write(answer+"\n");
        }
        bw.close();
    }
}

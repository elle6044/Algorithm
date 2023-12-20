import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N=Integer.parseInt(br.readLine());
        Map<String,Integer> map=new TreeMap<>();

        int maxNum=0;
        String maxName="";
        for(int i=0;i<N;i++){
            String input=br.readLine();
            int newNum=map.getOrDefault(input,0)+1;
            map.put(input,newNum);
            maxNum=Math.max(maxNum,newNum);
        }

        for(String name:map.keySet()){
            if(map.get(name)==maxNum){
                bw.write(name);
                break;
            }
        }
        bw.close();

    }
}

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N=Integer.parseInt(br.readLine());

        Map<Integer, Set<String>> map=new TreeMap<>();
        for(int i=0;i<N;i++){
            String input=br.readLine();
            int idx=input.length();
            Set<String> set;
            if (map.containsKey(idx)){
                set=map.get(idx);
            }
            else {
                set=new TreeSet<>();
            }
            set.add(input);
            map.put(idx,set);
        }

        for (Integer idx : map.keySet()) {
//            System.out.println(idx);
            Set<String> set=map.get(idx);
//            System.out.println(Arrays.toString(set.toArray()));
            for (String string : set) {
                bw.write(string+"\n");
            }
        }
        bw.close();
    }
}

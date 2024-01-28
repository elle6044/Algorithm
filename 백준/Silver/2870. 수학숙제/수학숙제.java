import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N=Integer.parseInt(br.readLine());

        Map<String,Integer> map=new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length()!=0?o1.length()-o2.length():o1.compareTo(o2);
            }
        });
        for(int n=0;n<N;n++){
            String input=br.readLine();

            Queue<Character> q=new ArrayDeque<>();
            for(int i=0;i<input.length();i++){
                int word=input.charAt(i)-48;
                if(word>=0&&word<=9){
                    q.offer(input.charAt(i));
                }
                else{
                    if(!q.isEmpty()){
                        String num="";
                        while(!q.isEmpty()){
                            char output=q.poll();
                            if(!q.isEmpty()&&num.isEmpty()&&output=='0'){
                                continue;
                            }
                            num+=output;
                        }
                        map.put(num,map.getOrDefault(num,0)+1);
                    }
                }
            }

            if(!q.isEmpty()){
                String num="";
                while(!q.isEmpty()){
                    char output=q.poll();
                    if(!q.isEmpty()&&num.isEmpty()&&output=='0'){
                        continue;
                    }
                    num+=output;
                }
                map.put(num,map.getOrDefault(num,0)+1);
            }
        }
        for (String number : map.keySet()) {
            for(int i=0;i<map.get(number);i++){
                bw.write(number+"\n");
            }
        }
        bw.close();
    }
}

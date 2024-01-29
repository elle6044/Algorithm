import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String input=br.readLine();
        ArrayList<Integer> arrayList=new ArrayList<>();
        int answer=0;
        for(int i=0;i<input.length();i++){
            char word=input.charAt(i);
            if(word=='q'){
                arrayList.add(1);
                answer=Math.max(answer,arrayList.size());
            } else if (word=='u') {
                if(arrayList.contains(1)){
                    arrayList.remove((Integer) 1);
                    arrayList.add(2);
                }
                else{
                    answer=-1;
                    break;
                }
            } else if (word=='a') {
                if(arrayList.contains(2)){
                    arrayList.remove((Integer) 2);
                    arrayList.add(3);
                }
                else{
                    answer=-1;
                    break;
                }
            } else if (word=='c') {
                if(arrayList.contains(3)){
                    arrayList.remove((Integer) 3);
                    arrayList.add(4);
                }
                else{
                    answer=-1;
                    break;
                }
            } else if (word=='k') {
                if(arrayList.contains(4)){
                    arrayList.remove((Integer) 4);
                }
                else{
                    answer=-1;
                    break;
                }
            }
        }
        if(!arrayList.isEmpty()){
            answer=-1;
        }

        bw.write(answer+"");
        bw.close();
    }
}

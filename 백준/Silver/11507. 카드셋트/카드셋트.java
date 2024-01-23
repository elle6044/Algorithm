import java.io.*;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String input=br.readLine()+" ";
        Set<String> set=new TreeSet<>();
        int[] array=new int[4];

        for(int i=0;i<input.length()-1;i+=3){
            String card=input.substring(i,i+3);
            if(set.contains(card)){
                bw.write("GRESKA");
                bw.close();
                return;
            }
            else{
                set.add(card);
                switch (card.charAt(0)){
                    case 'P':
                        array[0]++;
                        break;
                    case 'K':
                        array[1]++;
                        break;
                    case 'H':
                        array[2]++;
                        break;
                    case 'T':
                        array[3]++;
                        break;
                }
            }
        }
        for(int i=0;i<4;i++){
            bw.write((13-array[i])+" ");
        }
        bw.close();
    }
}

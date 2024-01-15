import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String input=br.readLine();
        int[] array=new int[9];

        for(int i=0;i<input.length();i++){
            int num=Character.getNumericValue(input.charAt(i));
            if(num==9){
                array[6]++;
            }
            else{
                array[num]++;
            }
        }
        array[6]=array[6]%2==0?array[6]/2:array[6]/2+1;

        Arrays.sort(array);
        bw.write(array[8]+"");
        bw.close();
    }
}

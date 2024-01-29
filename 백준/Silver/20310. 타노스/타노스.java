import java.io.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String input=br.readLine();
        char[] array=new char[input.length()];
        int zeroCnt=0;
        int oneCnt=0;
        for(int i=0;i<input.length();i++){
            char word=input.charAt(i);
            array[i]=word;
            if(word=='0'){
                zeroCnt++;
            }
            else{
                oneCnt++;
            }
        }
        zeroCnt/=2;
        oneCnt/=2;

        for (int i=0;i<input.length();i++){
            if(array[i]=='1'&&oneCnt>0){
                array[i]=' ';
                oneCnt--;
            }
            if(array[input.length()-i-1]=='0'&&zeroCnt>0){
                array[input.length()-i-1]=' ';
                zeroCnt--;
            }
        }

        for (char c : array) {
            if(c!=' '){
                bw.write(c);
            }
        }
        bw.close();
    }
}

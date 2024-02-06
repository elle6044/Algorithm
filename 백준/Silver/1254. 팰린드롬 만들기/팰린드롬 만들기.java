import java.io.*;
import java.util.Stack;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String input=br.readLine();

        int cnt=0;
        while(cnt<input.length()){
            if(isPalindrome(input.substring(cnt))){
                bw.write((input.length()+cnt)+"");
                break;
            }
            cnt++;
        }
        bw.close();

    }

    private static boolean isPalindrome(String input) {
        int idx1=0;
        int idx2=input.length()-1;
        while(idx1<idx2){
            if(input.charAt(idx1)!=input.charAt(idx2)){
                return false;
            }
            idx1++;
            idx2--;
        }
        return true;
    }
}

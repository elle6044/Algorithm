import java.io.*;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String input=br.readLine();
        int len=input.length();

        String answer="";


        for(int i=0;i<len-2;i++){
            String word1=new StringBuilder(input.substring(0,i+1)).reverse().toString();
            if(!answer.isEmpty()&&word1.compareTo(answer)>0){
                continue;
            }
            for(int j=i+1;j<len-1;j++){
                String word2=new StringBuilder(input.substring(i+1,j+1)).reverse().toString();
                String word3=new StringBuilder(input.substring(j+1)).reverse().toString();

                String newWord=word1+word2+word3;

                if(answer.isEmpty()){
                    answer=newWord;
                }
                else{
                    if(newWord.compareTo(answer)<0){
                        answer=newWord;
                    }
                }
            }
        }

        bw.write(answer);
        bw.close();
    }
}

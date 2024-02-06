import java.io.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int T=Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            int k=Integer.parseInt(br.readLine());
            StringBuilder[] words=new StringBuilder[k];
            for(int i=0;i<k;i++){
                words[i]=new StringBuilder(br.readLine());
            }

            String answer="0";
            L:for(int i=0;i<k;i++){
                for(int j=0;j<k;j++){
                    if(i==j)continue;
                    StringBuilder input=new StringBuilder(words[i]);
                    if(isPalindrome(input.append(words[j]))){
                        answer=input.toString();
                        break L;
                    }
                }
            }
            bw.write(answer+"\n");
        }

        bw.close();
    }

    private static boolean isPalindrome(StringBuilder input) {
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

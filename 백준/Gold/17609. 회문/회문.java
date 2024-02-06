import java.io.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int T=Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            String input=br.readLine();

            int p1=0;
            int p2=input.length()-1;
            int isPal=0;
            input=input+" ";
            while(p1<=p2){
                if(input.charAt(p1)==input.charAt(p2)){

                }
                else{
                    String sub1=input.substring(p1,p2);
                    String sub2=input.substring(p1+1,p2+1);
                    if(isPalindrome(sub1)||isPalindrome(sub2)){
                        isPal=1;
                    }
                    else{
                        isPal=2;
                    }
                    break;
                }
                p1++;
                p2--;
            }
            bw.write(isPal+"\n");
        }
        bw.close();
    }

    private static boolean isPalindrome(String input) {
        int p1=0;
        int p2=input.length()-1;
        while(p1<p2){
            if(input.charAt(p1)!=input.charAt(p2)){
                return false;
            }
            p1++;
            p2--;
        }
        return true;
    }
}

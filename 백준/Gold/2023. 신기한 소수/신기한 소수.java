import java.io.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] first={2,3,5,7};
    static int[] last={1,3,7,9};

    static int N;

    static int num=0;

    public static void main(String[] args) throws IOException {
        N=Integer.parseInt(br.readLine());

        for (int i : first) {
            num=i;
            back(1);
        }
    }

    private static void back(int cnt) {
        if(cnt==N){
            System.out.println(num);
            return;
        }

        for(int i=0;i< last.length;i++){
            num=num*10+last[i];
            if(isPrime()){
                back(cnt+1);
            }
            num-=last[i];
            num/=10;
        }
    }

    private static boolean isPrime(){
        int n=(int)Math.sqrt(num)+1;
        for(int i=2;i<=n;i++){
            if(num%i==0){
                return false;
            }
        }

        return true;
    }
}

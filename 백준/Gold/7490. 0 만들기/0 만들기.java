import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[] operator={32,43,45};

    public static void main(String[] args) throws Exception {
        int T=nextInt();
        for(int t=0;t<T;t++){
            N=nextInt();
            int[] array=new int[N*2-1];
            for(int i=0;i<N;i++){
                array[i*2]=i+1;
            }
            recursive(array,1);
            System.out.println();
        }
    }

    private static void recursive(int[] array, int cnt) throws IOException {
        if(cnt==N*2-1){
            int sum=0;
            int temp=0;
            int spaceCnt=0;
            for(int i=2*N-2;i>=0;i--){
                if(array[i]==43){
                    sum+=temp;
                    temp=0;
                    spaceCnt=0;
                } else if (array[i]==45) {
                    sum-=temp;
                    temp=0;
                    spaceCnt=0;
                } else if (array[i]==32) {
                    int num=array[i-1];
                    for (int j=0;j<=spaceCnt;j++){
                        num*=10;
                    }
                    temp+=num;
                    spaceCnt++;
                    i--;
                } else {
                    temp=array[i];
                }
            }
            if(sum+temp==0){
                for(int i=0;i<array.length;i++){
                    if(array[i]==43){
                        System.out.print("+");
                    } else if (array[i]==45) {
                        System.out.print("-");
                    } else if (array[i]==32) {
                        System.out.print(" ");
                    } else {
                        System.out.print(array[i]);
                    }
                }
                System.out.println();
            }

            return;
        }

        for(int i=0;i<3;i++){
            array[cnt]=operator[i];
            recursive(array,cnt+2);
        }
    }

    // 43 45 32
    static int nextInt() throws Exception {
        int sign = 0;
        int n = 0;
        int c;
        while ((c = System.in.read()) <= 32);
        if(c == 45) {
            sign = 1;
            c = System.in.read();
        }
        do n = (n << 3) + (n << 1) + (c & 15);
        while ((c = System.in.read()) > 47 && c < 58);
        return sign == 0 ? n : ~n + 1;
    }

}

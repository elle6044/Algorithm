import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static int N,K;

    static class Point{
        int num;
        Point next;
        public Point(int num){
            this.num=num;
            this.next=null;
        }
    }

    public static void main(String[] args) throws Exception {
        N=nextInt();
        K=nextInt();

        Point head=new Point(1);
        Point tail=head;
        for(int i=2;i<=N;i++){
            tail.next=new Point(i);
            tail=tail.next;
        }
        tail.next=head;

        bw.write("<");
        Point current=head;
        while(N-->0){
            for(int i=0;i<K-1;i++){
                current=current.next;
            }


            if(N!=0){
                bw.write(current.num+", ");
            }
            else{
                bw.write(current.num+">");
            }

            current.num=current.next.num;
            current.next=current.next.next;
        }
        
        bw.close();
    }

    static int nextInt() throws Exception {
        int sign=0;
        int n=0;
        int c;
        while((c=System.in.read())<=32);
        if(c==45){
            sign=1;
            c=System.in.read();
        }
        do n=(n<<3)+(n<<1)+(c&15);
        while((c=System.in.read())>47&&c<58);
        return sign==0?n:~n+1;
    }
}

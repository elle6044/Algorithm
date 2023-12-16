import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static int N,K;

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }


    public static void main(String[] args) throws Exception {
        N=nextInt();
        K=nextInt();

        Node head = new Node(1);
        Node tail = head;
        
        for (int i = 2; i <= N; i++) {
            tail.next = new Node(i);
            tail = tail.next;
        }
        tail.next = head;

        bw.write("<");

        Node current = head;
        while (N-- > 0) {
            for (int i = 1; i < K; i++) {
                current = current.next;
            }
            bw.write(current.data+"");
            if (N > 0) bw.write(", ");
            
            current.data = current.next.data;
            current.next = current.next.next;
        }
        bw.write(">");
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

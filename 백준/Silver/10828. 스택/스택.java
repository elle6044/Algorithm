import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N=Integer.parseInt(br.readLine());
        Stack stack=new Stack(N);
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            String command=st.nextToken();
            switch (command){
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    bw.write(stack.pop()+"\n");
                    break;
                case "size":
                    bw.write(stack.size()+"\n");
                    break;
                case "empty":
                    bw.write(stack.empty()+"\n");
                    break;
                case "top":
                    bw.write(stack.top()+"\n");
            }
        }
        bw.close();
    }

    static class Stack{
        int[] array;
        int maxSize;
        int top;

        public Stack(int maxSize){
            this.maxSize=maxSize;
            array=new int[maxSize];
            top=-1;
        }

        public void push(int num){
            if(top<maxSize-1){
                array[++top]=num;
            }
            else{
                int newSize=maxSize*2;
                int[] temp=new int[newSize];
                System.arraycopy(array,0,temp,0,maxSize);
                array=temp;
                maxSize=newSize;
                array[++top]=num;
            }
        }

        public int pop(){
            if(empty()==1){
                return -1;
            }
            else{
                return array[top--];
            }
        }

        public int size(){
            return top+1;
        }

        public int top(){
            if(empty()==1){
                return -1;
            }
            else{
                return array[top];
            }
        }

        public int empty(){
            if(top==-1){
                return 1;
            }
            else{
                return 0;
            }
        }
    }
}

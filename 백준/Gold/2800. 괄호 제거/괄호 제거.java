import java.io.*;
import java.util.Arrays;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static int size;
    static Set<String> set=new TreeSet<>();

    public static void main(String[] args) throws IOException {
        StringBuilder input=new StringBuilder(br.readLine());
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)=='('){
                size++;
            }
        }

        recursive(input, 0,0);

        for (String output : set) {
            bw.write(output+"\n");
        }
        bw.close();
    }

    private static void recursive(StringBuilder input, int cnt, int removeCnt) {
        if(cnt==size){
            if(removeCnt!=0){
                set.add(input.toString());
            }
            return;
        }

        int openIdx=0;
        int closeIdx=0;

        Stack<Integer> openIdxs=new Stack<>();

        int openCnt=0;
        int closeCnt=0;



        for(int i=0;i<input.length();i++){
            if(input.charAt(i)=='('){
                openIdxs.push(i);
            }
            else if(input.charAt(i)==')'){
                if(closeCnt==cnt-removeCnt){
                    closeIdx=i;
                    break;
                }
                else{
                    openIdxs.pop();
                    closeCnt++;
                }
            }
        }

        openIdx=openIdxs.pop();

//        recursive(input.deleteCharAt(closeIdx).deleteCharAt(openIdx), cnt+1, removeCnt+1);
//        input.insert(openIdx,'(');
//        input.insert(closeIdx,')');
        StringBuilder newInput=new StringBuilder(input);
        recursive(newInput.deleteCharAt(closeIdx).deleteCharAt(openIdx), cnt+1, removeCnt+1);

        recursive(input,cnt+1,removeCnt);
    }
}

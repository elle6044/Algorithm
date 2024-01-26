import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Set<Character> moSet=new HashSet<>();
        moSet.add('a');
        moSet.add('e');
        moSet.add('i');
        moSet.add('o');
        moSet.add('u');

        L:while(true){
            String input=br.readLine();
            if(input.equals("end")) break;

            boolean check1= moSet.contains(input.charAt(0));
            int check2=moSet.contains(input.charAt(0))?1:-1;
            char temp=input.charAt(0);

            for(int i=1;i<input.length();i++){
                char now=input.charAt(i);
                if(moSet.contains(now)){
                    check1=true;
                    if(check2<0){
                        check2=1;
                    }
                    else{
                        check2++;
                        if(check2>=3){
                            bw.write("<"+input+"> is not acceptable.\n");
                            continue L;
                        }
                    }
                }
                else{
                    if(check2>0){
                        check2=-1;
                    }
                    else{
                        check2--;
                        if(check2<=-3){
                            bw.write("<"+input+"> is not acceptable.\n");
                            continue L;
                        }
                    }
                }

                if(temp==now){
                    if(temp!='e'&&temp!='o'){
                        bw.write("<"+input+"> is not acceptable.\n");
                        continue L;
                    }
                }
                temp=now;
            }
            if(check1){
                bw.write("<"+input+"> is acceptable.\n");
            }
            else{
                bw.write("<"+input+"> is not acceptable.\n");
            }
        }
        bw.close();
    }
}

import java.io.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String input=br.readLine();
        String answer="";
        int isJava=0;

        for(int i=0;i<input.length();i++){
            int word=input.charAt(i);

            if(word==95){
                if(isJava>=0){
                    isJava=1;
                    if(i!=0&&i!=input.length()-1&&input.charAt(i+1)!='_'){
                        if((int)input.charAt(i+1)>=65&&(int)input.charAt(i+1)<=90){
                            answer="Error!";
                            break;
                        }
                        answer+=(char)(input.charAt(i+1)-32);
                        i++;
                    }
                    else{
                        answer="Error!";
                        break;
                    }
                }
                else{
                    answer="Error!";
                    break;
                }
            }
            else if(word>=65&&word<=90){
                if(isJava<=0){
                    isJava=-1;
                    if(i!=0){
                        answer+='_';
                        answer+=(char)(word+32);

                    }
                    else{
                        answer="Error!";
                        break;
                    }
                }
                else{
                    answer="Error!";
                    break;
                }
            }
            else{
                answer+=(char)word;
            }
        }
        bw.write(answer);
        bw.close();
    }
}

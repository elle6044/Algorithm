import java.util.*;
class Solution {
    public int solution(String word) {
        int answer = 0;
        array=new Character[5];
        input=word;
        back(0);
        answer=backAnswer;
        return answer;
    }
    static String input;
    static Character[] map={'A','E','I','O','U'};
    static Character[] array;
    static int count=0;
    static int backAnswer=0;
    public void back(int cnt){
        
        if(cnt==input.length()){
            boolean check=true;
            for(int i=0;i<input.length();i++){
                if(array[i]!=input.charAt(i)){
                    check=false;
                    break;
                }
            }
            if(check) backAnswer=count;
        }
        if(cnt==5) return;
        for(int i=0;i<5;i++){
            count++;
            array[cnt]=map[i];
            back(cnt+1);
        }
    }
}
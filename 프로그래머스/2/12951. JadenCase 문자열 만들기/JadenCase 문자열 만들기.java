import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb=new StringBuilder();
        boolean check=false;
        
        for(int i=0;i<s.length();i++){
            char word=s.charAt(i);
            
            if(word==' '){
                check=false;
            }
            else{
                if(!check){
                    if(word>=97&&word<=122){
                        word-=32;
                    }
                    check=true;
                }
                else{
                    if(word>=65&&word<=90){
                        word+=32;
                    }
                }
            }
            sb.append(word);
        }
        answer=sb.toString();
        return answer;
    }
}
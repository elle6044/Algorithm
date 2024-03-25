import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};

        Set<String> set=new HashSet();
        set.add(words[0]);
        char temp=words[0].charAt(words[0].length()-1);
        for(int i=1;i<words.length;i++){
            String word=words[i];
            if(set.contains(word)){
                answer[0]=(i+1)%n==0?n:(i+1)%n;
                answer[1]=(i+1)%n==0?(i+1)/n:(i+1)/n+1;
                break;
            }
            else{
                if(temp!=word.charAt(0)){
                    answer[0]=(i+1)%n==0?n:(i+1)%n;
                    answer[1]=(i+1)%n==0?(i+1)/n:(i+1)/n+1;
                    break;
                }
                else{
                    set.add(word);
                    temp=word.charAt(word.length()-1);
                }
            }
        }

        return answer;
    }
}
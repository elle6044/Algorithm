import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        Set<String>set=new HashSet();
        L:for(String number:phone_book){
            for(int i=1;i<number.length();i++){
                if(set.contains(number.substring(0,i))){
                    answer=false;
                    break L;
                }
            }
            set.add(number);
        }
        return answer;
    }
}
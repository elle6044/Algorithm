import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Deque<String> dq=new ArrayDeque();
        for(String city:cities){
            StringBuilder sb=new StringBuilder();
            if(cacheSize==0) return 5*cities.length;
            for(int i=0;i<city.length();i++){
                sb.append(Character.toUpperCase(city.charAt(i)));
            }
            city=sb.toString();
            if(dq.contains(city)){
                dq.remove(city);
                dq.offerLast(city);
                answer+=1;
            }
            else{
                if(dq.size()==cacheSize){
                    dq.pollFirst();
                }
                dq.offerLast(city);
                answer+=5;
            }
        }
        return answer;
    }
}
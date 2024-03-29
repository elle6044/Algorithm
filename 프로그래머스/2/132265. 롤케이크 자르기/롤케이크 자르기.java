import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Set<Integer>set=new HashSet();
        Map<Integer,Integer>map=new HashMap();
        
        for(int i=0;i<topping.length;i++){
            map.put(topping[i],i);
        }
        
        int cnt=map.size();
        
        for(int i=0;i<topping.length;i++){
            set.add(topping[i]);
            if(i==map.get(topping[i])){
                cnt--;
            }
            if(set.size()==cnt){
                answer++;
            }
            else if(set.size()>cnt)break;
        }
        return answer;
    }
}
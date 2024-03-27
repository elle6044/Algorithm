import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer>map=new HashMap();
        for(int i=0;i<want.length;i++){
            map.put(want[i],number[i]);
        }
        Queue<String> q=new ArrayDeque();
        for(int i=0;i<discount.length;i++){
            String input=discount[i];
            q.offer(input);
            if(map.containsKey(input)){
                map.put(input,map.get(input)-1);
            }
            
            if(q.size()>=10) {
                boolean check=true;
                for(String name:map.keySet()){
                    if(map.get(name)!=0){
                        check=false;
                        break;
                    }
                }
                if(check)answer++;
                
                String output=q.poll();
                if(map.containsKey(output)){
                    map.put(output,map.get(output)+1);
                }
            }
            
        }
        return answer;
    }
}
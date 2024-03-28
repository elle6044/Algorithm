import java.util.*;
class Solution {
    public int[] solution(String s) {
        
        String[] map=s.substring(2,s.length()-2).split("\\},\\{");
        int[] answer = new int[map.length];
        Set<Integer>set=new HashSet();
        int cnt=1;
        while(cnt<=map.length){
            for(int i=0;i<map.length;i++){
                String[] nums=map[i].split(",");
                if(nums.length==cnt){
                    for(String num:nums){
                        int a=Integer.parseInt(num);
                        if(!set.contains(a)){
                            answer[cnt-1]=a;
                            set.add(a);
                        }
                    }
                    cnt++;
                }
            }
        }
        
        return answer;
    }
}
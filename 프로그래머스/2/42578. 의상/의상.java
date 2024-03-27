import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        Map<String,Integer>map=new HashMap();
        for(int i=0;i<clothes.length;i++){
            map.put(clothes[i][1],map.getOrDefault(clothes[i][1],0)+1);
        }
        
        int cnt=0;
        array=new int[map.size()];
        for(String output:map.keySet()){
            array[cnt++]=map.get(output);
        }
        
        for(int i=1;i<=map.size();i++){
            back(i,0,1);
        }
        answer+=all;
        return answer;
    }
    static int all=0;
    public void back(int cnt, int idx, int sum){
        if(cnt==0){
            all+=sum;
            return;
        }
        if(cnt>array.length-idx) return;
        
        back(cnt-1, idx+1, sum*array[idx]);
        back(cnt, idx+1, sum);
    }
    
    
    static int[] array;
    
    
}
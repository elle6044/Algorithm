class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        end=target;
        map=words;
        v=new boolean[words.length];
        back(0,begin);
        answer=min==Integer.MAX_VALUE?0:min;
        return answer;
    }
    static int min=Integer.MAX_VALUE;
    public void back(int cnt, String word){
        if(word.equals(end)){
            min=Math.min(min,cnt);
        }
        
        for(int i=0;i<map.length;i++){
            if(!v[i]&&check(word,map[i])){
                v[i]=true;
                back(cnt+1,map[i]);
                v[i]=false;
            }
        }
    }
    public boolean check(String a, String b){
        int cnt=0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)) cnt++;
        }
        return cnt==1;
    }
    
    static String end;
    static String[] map;
    static boolean[] v;
}
class Solution {
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        N=dungeons.length;
        map=dungeons;
        v=new boolean[N];
        back(0,k);
        answer=max;
        return answer;
    }
    static int max=0;
    public void back(int cnt, int health){
        max=Math.max(max,cnt);
        
        for(int i=0;i<N;i++){
            if(!v[i]){
                if(health>=map[i][0]){
                    v[i]=true;
                    back(cnt+1,health-map[i][1]);
                    v[i]=false;
                }
            }
        }
    }
    
    static int N;
    static int[][] map;
    static boolean[] v;
}
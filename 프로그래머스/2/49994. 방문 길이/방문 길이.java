import java.util.*;
class Solution {
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,1,-1};
    static Map<Character, Integer> dirMap=new HashMap();
    public int solution(String dirs) {
        int answer = 0;
        dirMap.put('U',0);
        dirMap.put('D',1);
        dirMap.put('R',2);
        dirMap.put('L',3);
        int N=11;
        boolean[][] v=new boolean[122][122];
        int r=5;
        int c=5;
        for(int i=0;i<dirs.length();i++){
            char input=dirs.charAt(i);
            int d=dirMap.get(input);
            int nr=r+dr[d];
            int nc=c+dc[d];
            if(nr>=0&&nr<11&&nc>=0&&nc<11){
                if(!v[r*11+c][nr*11+nc]||!v[nr*11+nc][r*11+c]){
                    answer++;
                    v[r*11+c][nr*11+nc]=true;
                    v[nr*11+nc][r*11+c]=true;
                }
                r=nr;
                c=nc;
            }
        }
        
        
        return answer;
    }
}
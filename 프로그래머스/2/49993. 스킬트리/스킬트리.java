import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        ArrayList<Character> array=new ArrayList();
        for(int i=0;i<skill.length();i++){
            array.add(skill.charAt(i));
        }
        
        L:for(String input:skill_trees){
            int idx=0;
            for(int i=0;i<input.length();i++){
                char a=input.charAt(i);
                if(array.contains(a)){
                    if(a!=array.get(idx)){
                        continue L;
                    }
                    else idx++;
                }
            }
            answer++;
        }
        return answer;
    }
}
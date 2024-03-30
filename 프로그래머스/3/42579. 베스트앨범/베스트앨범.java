import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        Map<String, Integer> genreMap=new HashMap();
        Map<String, PriorityQueue> songMap=new HashMap();
        for(int i=0;i<genres.length;i++){
            int num=i;
            String genre=genres[i];
            int cnt=plays[i];
            genreMap.put(genre,genreMap.getOrDefault(genre,0)+cnt);
            
            if(songMap.containsKey(genre)){
                songMap.get(genre).offer(new Song(num,cnt));
            }
            else{
                PriorityQueue<Song> pq=new PriorityQueue();
                pq.offer(new Song(num,cnt));
                songMap.put(genre,pq);
            }
        }
        
        Map<Integer,String> genreMap2=new TreeMap(Comparator.reverseOrder());
        for(String genre:genreMap.keySet()){
            genreMap2.put(genreMap.get(genre),genre);
        }
        
        Queue<Integer> q=new ArrayDeque();
        for(int a:genreMap2.keySet()){
            String genre=genreMap2.get(a);
            PriorityQueue<Song> pq=songMap.get(genre);
            int size=pq.size();
            for(int i=0;i<Math.min(size,2);i++){
                Song song=pq.poll();
                q.offer(song.num);
            }
        }
        answer=new int[q.size()];
        for(int i=0;i<answer.length;i++){
            answer[i]=q.poll();
        }
        
        return answer;
    }
    
    static class Song implements Comparable<Song>{
        int num,cnt;
        public Song(int num, int cnt){
            this.num=num;
            this.cnt=cnt;
        }
        
        @Override
        public int compareTo(Song o){
            return o.cnt==this.cnt?this.num-o.num:o.cnt-this.cnt;
        }
    }
    
    
}
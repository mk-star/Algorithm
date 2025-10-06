import java.util.*;

class Song implements Comparable<Song> {
    int no;
    int cnt;
    
    Song(int no, int cnt) {
        this.no = no;
        this.cnt = cnt;
    }
    
    @Override
    public int compareTo(Song s) {
        if(this.cnt == s.cnt) return this.no - s.no;
        return s.cnt - this.cnt;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, List<Song>> map = new HashMap<>();
        Map<String, Integer> sum = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
            // 장르 별 고유 번호, 횟수 저장
            String key = genres[i];
            if(map.containsKey(key)) map.get(key).add(new Song(i, plays[i]));
            else map.put(key, new ArrayList<>(List.of(new Song(i, plays[i]))));

            // 장르 별 횟수의 합 저장
            if(sum.containsKey(key)) sum.put(key, sum.get(key) + plays[i]);
            else sum.put(key, plays[i]);
        }
        
        // 내림차순 정렬
        List<String> keySet = new ArrayList<>(sum.keySet());
        keySet.sort((o1, o2) -> sum.get(o2).compareTo(sum.get(o1)));
        
        List<Integer> result = new ArrayList<>();
        for(String key : keySet) {
            Collections.sort(map.get(key));
            int cnt = 0;
            for(Song s : map.get(key)) {
                result.add(s.no);
                cnt++;
                if(cnt % 2 == 0) break;
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
// 고유번호: i
// genres -> 장르, plays -> 재생된 횟수

// 장르별로 총 재생 횟수가 큰 거
// 횟수 -> 고유 번호가 낮은
// 장르별로 최대 2개